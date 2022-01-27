package com.lenir.translate_service.translater;

import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.KakaoLanguageRecognitionResult;
import com.lenir.translate_service.results.KakaoTranslateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KakaoTranslateServiceTests {
    @Autowired
    KakaoTranslateService kakaoTranslateService;

    @Test
    void kakaoLanguageRecognizeTest(){
        // Setup
        String translateTarget = "This sucks.";
        // 확인 요청
        Optional<KakaoLanguageRecognitionResult> recognitionResult = Optional.ofNullable(
                kakaoTranslateService.recognizeLanguage(translateTarget)
        );
        // 결과 확인
        assertTrue(recognitionResult.isPresent());
        assertEquals(Language.EN, recognitionResult.get().getLanguage());
    }

    @Test
    void kakaoTranslateTest(){
        // Setup
        String translateTarget = "Hamberger";
        Language targetLang = Language.KR;
        // 번역 요청
        Optional<KakaoTranslateResult> translateResult = Optional.ofNullable(
                kakaoTranslateService.translate(translateTarget, targetLang)
        );
        // 결과 비교
        String expected = "햄버거";
        assertTrue(translateResult.isPresent());
        assertEquals(expected, translateResult.get().getTranslatedText());
    }
}