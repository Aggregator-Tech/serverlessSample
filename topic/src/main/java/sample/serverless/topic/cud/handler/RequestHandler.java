package sample.serverless.topic.cud.handler;

import org.jvnet.hk2.annotations.Contract;
import sample.serverless.topic.cud.Request;
import sample.serverless.topic.cud.Response;

@Contract
public interface RequestHandler {
    public Response handle(Request request);
}
