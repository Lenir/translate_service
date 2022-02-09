package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;

import java.util.concurrent.Future;

public interface PortalLanguageDetectCommunicator {
    SimpleHttpRequest buildHttpRequest(PortalLanguageDetectParameter detectParameter);
    public Future<SimpleHttpResponse> getFutureResponse(PortalLanguageDetectParameter detectParameter);
}
