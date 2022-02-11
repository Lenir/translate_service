package com.lenir.translate_service.communicator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class KakaoTranslateResponse {
    @JsonProperty("translated_text")
    List<List<String>> translatedText;
}
