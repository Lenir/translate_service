package com.lenir.translate_service.service;

import com.lenir.translate_service.results.TranslateResult;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {
    public TranslateResult translate(String translateTarget, String targetLang) {
        return new TranslateResult();
    }
}
