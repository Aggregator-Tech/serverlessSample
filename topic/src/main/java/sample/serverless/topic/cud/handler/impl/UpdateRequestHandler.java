package sample.serverless.topic.cud.handler.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.jvnet.hk2.annotations.Service;
import sample.serverless.topic.cud.Request;
import sample.serverless.topic.cud.Response;
import sample.serverless.topic.cud.handler.RequestHandler;
import sample.serverless.topic.object.Topic;

import java.util.UUID;

@Service(name="update")
public class UpdateRequestHandler implements RequestHandler {
    @Override
    public Response handle(Request request) {
        Topic newTopic = createTopicObject(request);
        persistTopic(newTopic);
        return new Response(newTopic.getTopicId(), newTopic);

    }

    private void persistTopic(Topic newTopic) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.save(newTopic);
    }

    private Topic createTopicObject(Request request) {
        String topicId = UUID.randomUUID().toString();
        Topic topic = request.getTopic();
        topic.setTopicId(topicId);
        return topic;
    }

}
