package com.lenir.translate_service.communicator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoLanguageInfo {
    String code;
    String name;
    String confidence;
}
