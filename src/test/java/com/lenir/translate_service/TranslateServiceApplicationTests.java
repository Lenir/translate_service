package com.lenir.translate_service;

import com.lenir.translate_service.enums.Language;
import com.lenir.translate_service.results.RankingResult;
import com.lenir.translate_service.results.TranslateResult;
import com.lenir.translate_service.service.RankingService;
import com.lenir.translate_service.service.TranslateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslateServiceApplicationTests {
	@Autowired
	TranslateService translateService;

	@Autowired
	RankingService rankingService;

	@Test
	void translateServiceTest(){
		// Setup
		String translateTarget = "Hamberger";
		Language targetLang = Language.KR;
		// 번역 요청
		Optional<TranslateResult> translateResult = Optional.ofNullable(
				translateService.translate(translateTarget, targetLang));
		// 결과 비교
		assertTrue(translateResult.isPresent());
	}
	
	@Test
	void rankingServiceTest(){
		// 순위 요청
		Optional<RankingResult> rankingResult = Optional.ofNullable(rankingService.ranking());
		// 결과 비교
		assertTrue(rankingResult.isPresent());
	}

}
