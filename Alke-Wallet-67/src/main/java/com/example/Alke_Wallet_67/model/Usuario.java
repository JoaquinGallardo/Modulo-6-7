package com.example.Alke_Wallet_67.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;
    private String nombre;
    private String apellido;
    private String rut;
    private String email;
    private String password;
    private double saldo;

}
