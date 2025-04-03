package com.myproject.desafio_picpay_backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Transactions")
@Table(name="Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id", foreignKey = @ForeignKey(name = "fk_transaction_sender"))
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id", foreignKey = @ForeignKey(name ="fk_transaction_receiver"))
    private User receiver;

    private LocalDateTime timeStamp;

}
