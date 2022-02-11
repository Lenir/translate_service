package com.lenir.translate_service.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoTranslateResult implements OriginTranslateResult{
    private String translatedText;
}
