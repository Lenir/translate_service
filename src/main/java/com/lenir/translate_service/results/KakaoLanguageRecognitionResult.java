package com.lenir.translate_service.results;

import com.lenir.translate_service.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoLanguageRecognitionResult implements OriginLanguageRecognitionResult {
    private Language language;
}
