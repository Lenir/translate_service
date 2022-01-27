package com.lenir.translate_service;

import com.lenir.translate_service.results.RankingResult;
import com.lenir.translate_service.results.TranslateResult;
import com.lenir.translate_service.service.RankingService;
import com.lenir.translate_service.service.TranslateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TranslateServiceApplicationTests {
	@Autowired
	TranslateService translateService;

	@Autowired
	RankingService rankingService;

	@Test
	void translateServiceTest(){
		// Setup
		String translateTarget = "This sucks.";
		String targetLang = "kr";
		// 번역 요청
		TranslateResult translateResult = translateService.translate(translateTarget, targetLang);
		// 결과 비교
		assertNotNull(translateResult);
	}
	
	@Test
	void rankingServiceTest(){
		// 순위 요청
		RankingResult rankingResult = rankingService.ranking();
		// 결과 비교
		assertNotNull(rankingResult);
	}

}
