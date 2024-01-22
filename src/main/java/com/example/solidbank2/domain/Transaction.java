package com.example.solidbank2.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    Long transactionNumber;
    String clientID;
    String description;
    private static Long Counter = 1L;

    public Transaction(String clientID, String description) {
        this.transactionNumber=Counter++;
        this.clientID = clientID;
        this.description = description;
    }
}
