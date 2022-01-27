package com.lenir.translate_service.service;

import com.lenir.translate_service.results.RankingResult;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
    public RankingResult ranking() {
        return new RankingResult();
    }
}
