package com.lenir.translate_service.communicator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KakaoTranslateParameter implements PortalTranslateParameter{
    String query;
    String srcLang;
    String targetLang;

    @Override
    public String getQuery() {
        return this.query;
    }

    @Override
    public String getTargetLang() {
        return this.srcLang;
    }

    @Override
    public String getSourceLang() {
        return this.targetLang;
    }
}
