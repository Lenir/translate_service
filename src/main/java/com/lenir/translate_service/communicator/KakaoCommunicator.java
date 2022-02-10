package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;

@Component
public class KakaoCommunicator implements PortalCommunicator{
    @Value("${kakao.auth}")
    private String injectedKakaoAuthToken;

    private static String kakaoAuthToken;

    @PostConstruct
    public void postConstruct(){
//        kakaoBaseUrl = this.injectedKakaoBaseUrl;
        kakaoAuthToken = this.injectedKakaoAuthToken;
    }

    void setKakaoAuthorization(SimpleHttpRequest httpRequest, String kakaoAuthToken){
        httpRequest.setHeader("Authorization", kakaoAuthToken);
    }

    public Future<SimpleHttpResponse> getFutureResponse(PortalRequest portalRequest) {
        SimpleHttpRequest httpRequest = portalRequest.buildHttpRequest();
        setKakaoAuthorization(httpRequest, kakaoAuthToken);
        return AsyncHttpRequestHelper.requestAsyncHttpGet(httpRequest);
    }
}
