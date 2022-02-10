package com.lenir.translate_service.communicator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class KakaoLanguageDetectResponse {
    @JsonProperty("language_info")
    List<KakaoLanguageInfo> languageInfo;
}
