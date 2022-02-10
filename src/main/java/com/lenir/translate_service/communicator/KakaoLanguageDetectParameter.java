package com.lenir.translate_service.communicator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KakaoLanguageDetectParameter implements PortalLanguageDetectParameter{
    String query;

    @Override
    public String getQuery() {
        return this.query;
    }
}
