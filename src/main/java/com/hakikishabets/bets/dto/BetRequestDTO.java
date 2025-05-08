package com.hakikishabets.bets.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BetRequestDTO {

    @NotNull(message = "Stake is required")
    @Positive(message = "Stake must be greater than zero")
    private Double stake;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Match ID is required")
    private Long matchId;

    @NotNull(message = "Market ID is required")
    private Long marketId;

    @NotNull(message = "Odd ID is required")
    private Long oddId;
}
