package com.example.aposta.infra.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Table(name = "aposta")
@Entity
data class ApostaEntity (

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val idAposta : Long,

    @Column
    val valor : BigDecimal,

    @JoinColumn(name = "id_cliente")
    @MapsId
    @OneToOne
    val cliente : ClientEntity? = null

)