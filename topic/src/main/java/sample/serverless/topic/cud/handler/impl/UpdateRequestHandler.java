package sample.serverless.topic.cud.handler.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.jvnet.hk2.annotations.Service;
import sample.serverless.topic.cud.Request;
import sample.serverless.topic.cud.Response;
import sample.serverless.topic.cud.handler.RequestHandler;
import sample.serverless.topic.object.Topic;

import javax.inject.Inject;

@Service(name="update")
public class UpdateRequestHandler implements RequestHandler {

    DynamoDBMapper dynamoDBMapper;

    @Inject
    public UpdateRequestHandler(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public Response handle(Request request) {
        Topic newTopic = request.getTopic();
        Topic existingTopic = getTopic(newTopic.getTopicId());
        if(existingTopic == null) {
            throw new RuntimeException("Topic not found");
        }
        persistTopic(newTopic);
        return new Response(newTopic.getTopicId(), newTopic);

    }

    private void persistTopic(Topic newTopic) {
        dynamoDBMapper.save(newTopic);
    }

    private Topic getTopic(String topicId) {
        Topic topic = dynamoDBMapper.load(Topic.class,topicId);
        return topic;
    }

}
