package com.hakikishabets.bets.controller;

import com.hakikishabets.bets.dto.MarketResponseDTO;
import com.hakikishabets.bets.dto.MarketWithOddsDTO; // New DTO
import com.hakikishabets.bets.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
public class MarketController {

    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    // Get markets and their odds for a specific match
    @GetMapping("/match/{matchId}/with-odds")
    public ResponseEntity<List<MarketWithOddsDTO>> getMarketsWithOdds(@PathVariable Long matchId) {
        List<MarketWithOddsDTO> marketsWithOdds = marketService.getMarketsWithOddsForMatch(matchId);
        return ResponseEntity.ok(marketsWithOdds);
    }

    // Get markets for a specific match
    @GetMapping("/match/{matchId}")
    public ResponseEntity<List<MarketResponseDTO>> getMarketsForMatch(@PathVariable Long matchId) {
        List<MarketResponseDTO> markets = marketService.getMarketsForMatch(matchId);
        return ResponseEntity.ok(markets);
    }

    // Get market details by ID
    @GetMapping("/{id}")
    public ResponseEntity<MarketResponseDTO> getMarketById(@PathVariable Long id) {
        MarketResponseDTO market = marketService.getMarketDTOById(id);
        return ResponseEntity.ok(market);
    }
}
