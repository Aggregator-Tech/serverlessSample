package sample.serverless.topic.cud.handler.impl;

import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.hk2.annotations.Service;
import sample.serverless.topic.cud.Request;
import sample.serverless.topic.cud.handler.RequestHandler;

import javax.inject.Inject;


@Service
public class RequestHandlerFactory {
    ServiceLocator serviceLocator;

    @Inject
    public RequestHandlerFactory(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public RequestHandler getService(Request request) {
        RequestHandler requestHandler = null;
        requestHandler = serviceLocator.getService(RequestHandler.class, request.getOperation());
        return requestHandler;
    }
}
