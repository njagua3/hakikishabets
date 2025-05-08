package com.hakikishabets.bets.service;

import com.hakikishabets.bets.dto.MarketResponseDTO;
import com.hakikishabets.bets.dto.MarketWithOddsDTO; // New DTO to hold Market with odds
import com.hakikishabets.bets.mapper.MarketMapper;
import com.hakikishabets.bets.mapper.OddMapper;
import com.hakikishabets.bets.model.Market;
import com.hakikishabets.bets.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    // Get all markets with their odds for a specific match
    public List<MarketWithOddsDTO> getMarketsWithOddsForMatch(Long matchId) {
        List<Market> markets = marketRepository.findByGameId(matchId); // Fetch markets for match
        return markets.stream()
                .map(market -> {
                    // Create MarketWithOddsDTO and populate it
                    MarketWithOddsDTO dto = new MarketWithOddsDTO();
                    dto.setMarketId(market.getId());
                    dto.setMarketName(market.getName());
                    dto.setOdds(market.getOdds().stream()
                            .map(OddMapper::toDTO) // Assuming OddMapper.toDTO exists for converting Odds to DTO
                            .collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Existing methods
    public List<MarketResponseDTO> getMarketsForMatch(Long matchId) {
        List<Market> markets = marketRepository.findByGameId(matchId);
        return markets.stream()
                .map(MarketMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MarketResponseDTO getMarketDTOById(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new RuntimeException("Market not found"));
        return MarketMapper.toDTO(market);
    }

    public Market getMarketById(Long marketId) {
        return marketRepository.findById(marketId)
                .orElseThrow(() -> new RuntimeException("Market not found"));
    }
}
