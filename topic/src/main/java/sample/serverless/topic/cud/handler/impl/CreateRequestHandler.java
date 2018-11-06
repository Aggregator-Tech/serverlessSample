package sample.serverless.topic.cud.handler.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.jvnet.hk2.annotations.Service;
import platform.common.ServiceLocatorHelper;
import sample.serverless.topic.cud.Request;
import sample.serverless.topic.cud.Response;
import sample.serverless.topic.cud.handler.RequestHandler;
import sample.serverless.topic.object.Topic;

import javax.inject.Inject;
import java.util.UUID;

@Service(name="create")
public class CreateRequestHandler implements RequestHandler {
    DynamoDBMapper dynamoDBMapper;

    @Inject
    public CreateRequestHandler(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Response handle(Request request) {
        getLogger().log("inside CreateRequestHandler");
        Topic newTopic = createTopicObject(request);
        persistTopic(newTopic);
        return new Response(newTopic.getTopicId(), newTopic);

    }

    private void persistTopic(Topic newTopic) {
        dynamoDBMapper.save(newTopic);
    }

    private Topic createTopicObject(Request request) {
        String topicId = UUID.randomUUID().toString();
        Topic topic = request.getTopic();
        topic.setTopicId(topic.getSpaceId() + "_" + topicId);
        return topic;
    }

    public LambdaLogger getLogger() {
        return ServiceLocatorHelper.getServiceLocator()
                .getService(RequestHolder.class).getContext().getLogger();
    }

}
