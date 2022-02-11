package com.lenir.translate_service.communicator;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.springframework.beans.factory.annotation.Value;

public class KakaoTranslateRequest implements PortalRequest {
    @Value("${kakao.translate-service.uri}")
    private String kakaoBaseUrl;
    private PortalTranslateParameter translateParameter;

    public KakaoTranslateRequest(PortalTranslateParameter parameter){
        this.translateParameter = parameter;
    }

    @Override
    public SimpleHttpRequest buildHttpRequest() {
//        return SimpleRequestBuilder.get(kakaoBaseUrl)
        return SimpleRequestBuilder.get("https://dapi.kakao.com/v2/translation/translate") //TODO fix
                .addParameter("query", translateParameter.getQuery())
                .addParameter("src_lang", translateParameter.getSourceLang().toLowerCase())
                .addParameter("target_lang", translateParameter.getTargetLang().toLowerCase())
                .build();
    }
}
