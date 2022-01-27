package com.lenir.translate_service.results;

import com.lenir.translate_service.enums.Language;
import lombok.Getter;

@Getter
public class KakaoLanguageRecognitionResult implements OriginLanguageRecognitionResult {
    // TODO implement
    private Language language = Language.EN;
}
