package com.example.Alke_Wallet_67.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emisor;
    private String receptor;
    private double monto;
    private int fecha;


}
