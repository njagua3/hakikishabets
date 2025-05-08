package com.hakikishabets.bets.dto;

import com.hakikishabets.bets.model.BetStatus;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

@Data
public class BetResponseDTO {
    private Long id;
    @NotNull(message = "Stake must be > zero")
    @Positive
    private Double stake;
    private Double potentialWin;
    private BetStatus status;
    private LocalDateTime placedAt;
    private Long userId;
    private Long matchId;
    private Long marketId;
    private Long oddId;
}
