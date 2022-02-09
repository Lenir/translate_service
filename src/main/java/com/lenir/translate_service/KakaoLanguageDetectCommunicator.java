package com.lenir.translate_service;

import com.lenir.translate_service.communicator.KakaoCommunicator;
import com.lenir.translate_service.communicator.PortalTranslateCommunicator;
import com.lenir.translate_service.communicator.PortalTranslateParameter;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;

@Component
public class KakaoLanguageDetectCommunicator implements PortalTranslateCommunicator, KakaoCommunicator {
    @Value("${kakao.language-detect-service.uri}")
    private String injectedKakaoBaseUrl;

    @Value("${kakao.auth}")
    private String injectedKakaoAuthToken;

    private static String kakaoBaseUrl;
    private static String kakaoAuthToken;

    @PostConstruct
    public void postConstruct(){
        kakaoBaseUrl = this.injectedKakaoBaseUrl;
        kakaoAuthToken = this.injectedKakaoAuthToken;
    }

    @Override
    public SimpleHttpRequest buildHttpRequest(PortalTranslateParameter translateParameter) {
        return null;
    }

    @Override
    public Future<SimpleHttpResponse> getFutureResponse(PortalTranslateParameter translateParameter) {
        return null;
    }
}
