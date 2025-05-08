package com.hakikishabets.bets.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String username;
    private String email;
    private Double balance;
}
