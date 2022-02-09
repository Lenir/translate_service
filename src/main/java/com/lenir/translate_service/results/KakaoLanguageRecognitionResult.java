package com.lenir.translate_service.results;

import com.lenir.translate_service.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoLanguageRecognitionResult implements OriginLanguageRecognitionResult {
    private Language language;
}
