package com.lenir.translate_service.communicator;

import com.lenir.translate_service.communicator.KakaoLanguageDetectParameter;
import com.lenir.translate_service.communicator.PortalRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.springframework.beans.factory.annotation.Value;

public class KakaoLanguageDetectRequest implements PortalRequest {
    @Value("${kakao.language-detect-service.uri}")
    private String kakaoBaseUrl;
    KakaoLanguageDetectParameter parameter;

    public KakaoLanguageDetectRequest(KakaoLanguageDetectParameter parameter){
        this.parameter = parameter;
    }

    @Override
    public SimpleHttpRequest buildHttpRequest() {
        return SimpleRequestBuilder.get("https://dapi.kakao.com/v3/translation/language/detect") //TODO fix
                .addParameter("query", parameter.getQuery())
                .build();
    }
}
