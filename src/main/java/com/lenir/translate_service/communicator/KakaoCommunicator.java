package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;

public interface KakaoCommunicator {
    default void setKakaoAuthorization(SimpleHttpRequest httpRequest, String kakaoAuthToken){
        httpRequest.setHeader("Authorization", kakaoAuthToken);
    }
}
