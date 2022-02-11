package com.lenir.translate_service.communicator;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
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
        return this.targetLang;
    }

    @Override
    public String getSourceLang() {
        return this.srcLang;
    }
}
