package com.lenir.translate_service.communicator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoLanguageDetectResponse {
    @JsonProperty("language_info")
    List<KakaoLanguageInfo> languageInfo;
}
