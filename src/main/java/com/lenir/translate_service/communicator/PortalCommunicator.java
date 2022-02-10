package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;

import java.util.concurrent.Future;

public interface PortalCommunicator {
    public Future<SimpleHttpResponse> getFutureResponse(PortalRequest portalRequest);
}
