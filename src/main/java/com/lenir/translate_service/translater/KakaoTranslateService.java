package com.lenir.translate_service.translater;

import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.KakaoLanguageRecognitionResult;
import com.lenir.translate_service.results.KakaoTranslateResult;
import org.springframework.stereotype.Component;

@Component
public class KakaoTranslateService implements Translater {
    @Override
    public KakaoLanguageRecognitionResult recognizeLanguage(String translateTarget) {
        return new KakaoLanguageRecognitionResult();
    }

    @Override
    public KakaoTranslateResult translate(String translateTarget, Language asisLang, Language tobeLang) {
        return new KakaoTranslateResult();
    }

    @Override
    public KakaoTranslateResult translate(String translateTarget, Language asisLang) {
        return this.translate(translateTarget, asisLang, Language.KR);
    }
}
