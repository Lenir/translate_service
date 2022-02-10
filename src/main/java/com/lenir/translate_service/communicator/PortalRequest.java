package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;

public interface PortalRequest {
    SimpleHttpRequest buildHttpRequest();
}
