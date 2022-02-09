package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;

import java.util.concurrent.Future;

public interface PortalTranslateCommunicator {
    SimpleHttpRequest buildHttpRequest(PortalTranslateParameter translateParameter);
    public Future<SimpleHttpResponse> getFutureResponse(PortalTranslateParameter translateParameter);
}
