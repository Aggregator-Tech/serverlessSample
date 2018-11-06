package sample.serverless.topic.cud

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.glassfish.hk2.api.ServiceLocator
import sample.serverless.topic.object.Topic
import spock.lang.Specification

class TopicCUDTest extends Specification {
//    def "Test Create Topic" () {
//        setup:
//        ServiceLocator serviceLocator = Mock()
//        TopicCUD topicCUD = new TopicCUD(serviceLocator);
//        Request request = buildCreateRequest();
//        Context context = Mock()
//        when:
//        Response response = topicCUD.handleRequest(request, context)
//        then:
//        2*context.getLogger() >> Mock(LambdaLogger)
//        response != null
//    }
//
//    Request buildCreateRequest() {
//        Request request = new Request("create", buildTopicObject());
//        return request;
//    }
//
//    Request buildUpdateRequest() {
//        Request request = new Request("update", buildTopicObject());
//        return request;
//    }
//
//    Topic buildTopicObject() {
//        return new Topic("spaceId", "titleTitle", "titleContent");
//    }
}
