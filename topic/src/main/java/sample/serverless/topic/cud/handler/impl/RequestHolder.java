package sample.serverless.topic.cud.handler.impl;

import com.amazonaws.services.lambda.runtime.Context;
import org.glassfish.hk2.api.PerThread;
import org.jvnet.hk2.annotations.Service;
import sample.serverless.topic.cud.Request;

@Service
@PerThread
public class RequestHolder {
    private Context context;
    private Request request;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
