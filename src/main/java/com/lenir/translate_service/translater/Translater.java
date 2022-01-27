package com.lenir.translate_service.translater;


import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.OriginLanguageRecognitionResult;

public interface Translater {
    OriginLanguageRecognitionResult recognizeLanguage(String translateTarget);

    Object translate(String translateTarget, Language asisLang, Language tobeLang);
    Object translate(String translateTarget, Language asisLang);
}
