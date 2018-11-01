package sample.serverless.topic.cud;

import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.hk2.annotations.Service;
import platform.common.ServiceLocatorHelper;
import sample.serverless.topic.cud.handler.impl.RequestHandlerFactory;
import sample.serverless.topic.cud.handler.impl.RequestHolder;
import sample.serverless.topic.object.Topic;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import javax.inject.Inject;
import java.util.UUID;

public class TopicCUD implements RequestHandler<Request, Response> {
    ServiceLocator serviceLocator;

    public TopicCUD() {
        this.serviceLocator = ServiceLocatorHelper.getServiceLocator();
    }

    public Response handleRequest(Request request, Context context) {
        context.getLogger().log("Input: " + request.getOperation() + " " + request.getTopic().getTopicTitle());
        Response response;
        response = serviceLocator.getService(RequestHandlerFactory.class).getService(request)
                .handle(request);

        context.getLogger().log("Output: " + response.getTopic().getTopicId());
        return response;
    }


}