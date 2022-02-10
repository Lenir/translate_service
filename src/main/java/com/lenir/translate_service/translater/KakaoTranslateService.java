package com.lenir.translate_service.translater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenir.translate_service.KakaoLanguageDetectRequest;
import com.lenir.translate_service.communicator.AsyncHttpRequestHelper;
import com.lenir.translate_service.communicator.KakaoCommunicator;
import com.lenir.translate_service.communicator.KakaoLanguageDetectParameter;
import com.lenir.translate_service.communicator.KakaoLanguageDetectResponse;
import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.KakaoLanguageRecognitionResult;
import com.lenir.translate_service.results.KakaoTranslateResult;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class KakaoTranslateService implements Translater {
    private static final Logger logger = LogManager.getLogger(KakaoTranslateService.class);

    @Autowired
    KakaoCommunicator kakaoCommunicator;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public KakaoLanguageRecognitionResult recognizeLanguage(String translateTarget) {
        KakaoLanguageDetectParameter parameter = new KakaoLanguageDetectParameter(translateTarget);
        KakaoLanguageDetectRequest request = new KakaoLanguageDetectRequest(parameter);
        Future<SimpleHttpResponse> futureResponse = kakaoCommunicator.getFutureResponse(request);
        KakaoLanguageRecognitionResult result;
        try {
            SimpleHttpResponse response = futureResponse.get();
            KakaoLanguageDetectResponse kakaoResponse = objectMapper.readValue(response.getBodyText(), KakaoLanguageDetectResponse.class);
            result = new KakaoLanguageRecognitionResult(Language.valueOf(kakaoResponse.getLanguageInfo().get(0).getCode()));
        } catch (InterruptedException e) {
            logger.error(e);
            result = new KakaoLanguageRecognitionResult();
        } catch (ExecutionException | JsonProcessingException e) {
            logger.error(e);
            result = new KakaoLanguageRecognitionResult();
        }
        return result;
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
