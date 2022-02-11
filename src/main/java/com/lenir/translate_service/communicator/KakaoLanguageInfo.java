package com.lenir.translate_service.communicator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoLanguageInfo {
    String code;
    String name;
    String confidence;
}
