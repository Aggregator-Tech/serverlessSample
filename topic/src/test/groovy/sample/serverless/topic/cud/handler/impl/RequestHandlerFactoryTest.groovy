package sample.serverless.topic.cud.handler.impl

import org.glassfish.hk2.api.ServiceLocator
import platform.common.ServiceLocatorHelper
import sample.serverless.topic.cud.Request
import sample.serverless.topic.cud.handler.RequestHandler
import sample.serverless.topic.object.Topic
import spock.lang.Specification

class RequestHandlerFactoryTest extends Specification {
    def "Get Request Handler"() {
        given:
        ServiceLocator serviceLocator = ServiceLocatorHelper.getServiceLocator();
        RequestHandlerFactory requestHandlerFactory = serviceLocator.getService(RequestHandlerFactory.class);

        when:
        Request request = buildCreateRequest();
        RequestHandler requestHandler = requestHandlerFactory.getService(request);
        then:
        requestHandler instanceof CreateRequestHandler

        when:
        request = buildUpdateRequest();
        requestHandler = requestHandlerFactory.getService(request);
        then:
        requestHandler instanceof UpdateRequestHandler
    }

    Request buildCreateRequest() {
        Request request = new Request("create", buildTopicObject());
        return request;
    }

    Request buildUpdateRequest() {
        Request request = new Request("update", buildTopicObject());
        return request;
    }

    Topic buildTopicObject() {
        return new Topic("spaceId", "titleTitle", "titleContent");
    }
}
