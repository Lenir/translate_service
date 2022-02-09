package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;

@Component
public class KakaoTranslateCommunicator implements PortalTranslateCommunicator, KakaoCommunicator {
    @Value("${kakao.translate-service.uri}")
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
        return SimpleRequestBuilder.get(kakaoBaseUrl)
                .addParameter("query", translateParameter.getQuery())
                .addParameter("src_lang", translateParameter.getSourceLang())
                .addParameter("target_lang", translateParameter.getTargetLang())
                .build();
    }

    @Override
    public Future<SimpleHttpResponse> getFutureResponse(PortalTranslateParameter translateParameter) {
        SimpleHttpRequest httpRequest = this.buildHttpRequest(translateParameter);
        setKakaoAuthorization(httpRequest, kakaoAuthToken);
        return AsyncHttpRequestHelper.requestAsyncHttpGet(httpRequest);
    }
}
