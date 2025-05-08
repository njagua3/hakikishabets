package com.hakikishabets.bets.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity //Marks this class as a JPA entity (i.e., a table in the DB).
@Table(name = "users") // Specifies the table name; avoids conflict with "user" (a reserved keyword in SQL)
public class User {

    // Primary key with auto-incremented ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User's unique username
    @Setter
    @Column(unique = true)
    private String username;

    // User's email address
    @Setter
    @Column(unique = true)
    private String email;

    // Current balance in the user's account (e.g., for placing bets)
    @Setter
    private Double balance;

    // A user can place many bets. This sets up a one-to-many relationship.
    // 'mappedBy = "user"' means the Bet entity owns the relationship.
    // 'Cascade = CascadeType.ALL' propagates all operations (persist, merge, remove, etc.) to bets.
    // 'orphanRemoval = true' deletes any Bet removed from this list.
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bet> bets = new ArrayList<>();

    // Default constructor required by JPA
    public User() {}

    // Convenience constructor to create a User with initial values
    public User(String username, String email, Double balance) {
        this.username = username;
        this.email = email;
        this.balance = balance;
    }

}
