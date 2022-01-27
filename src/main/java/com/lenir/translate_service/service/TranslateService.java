package com.lenir.translate_service.service;

import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.TranslateResult;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {
    public TranslateResult translate(String translateTarget, Language targetLang) {
        return new TranslateResult();
    }
}
