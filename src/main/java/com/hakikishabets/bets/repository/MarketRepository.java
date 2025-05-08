package com.hakikishabets.bets.repository;

import com.hakikishabets.bets.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Long> {
    // Update method to use 'game.id' instead of 'matchId'
    List<Market> findByGameId(Long id); // Match -> Game
}
