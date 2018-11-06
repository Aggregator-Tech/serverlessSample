package sample.serverless.topic.cud

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class ObjectMapperTest extends Specification{

    def "Test json to java"() {
        ObjectMapper objectMapper = new ObjectMapper()
        String json = "{\n" +
                "\"operation\": \"create\",\n" +
                "\"topic\": {\n" +
                "  \"spaceId\": \"space1\",\n" +
                "  \"topicTitle\": \"TopicTitle1\",\n" +
                "  \"topicContent\": \"TopicContent1\"\n" +
                "}\n" +
                "}"
        when:
        Request request = objectMapper.readValue(json, Request.class);
        then:
        request.getOperation()=="create"
    }
}
