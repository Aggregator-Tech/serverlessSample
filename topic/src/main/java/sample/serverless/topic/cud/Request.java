package sample.serverless.topic.cud;

import sample.serverless.topic.object.Topic;

public class Request {
    String operation;
    Topic topic;

    public Request() {
    }

    public Request(String operation, Topic topic) {
        this.operation = operation;
        this.topic = topic;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}