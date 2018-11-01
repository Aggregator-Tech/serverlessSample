package sample.serverless.topic.cud.handler.impl;

import org.glassfish.hk2.api.Operation;
import org.glassfish.hk2.api.PerThread;
import org.jvnet.hk2.annotations.Service;
import sample.serverless.topic.cud.Request;

@Service
@PerThread
public class RequestHolder {
    private Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
