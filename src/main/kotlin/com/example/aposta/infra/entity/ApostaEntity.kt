package com.example.aposta.infra.entity

import com.example.aposta.domain.model.Aposta
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
import java.time.LocalDateTime

@Table(name = "aposta")
@Entity
data class ApostaEntity (

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val idAposta : Long = 0,

    @Column
    val valor : BigDecimal,

    @Column
    val dataAposta: LocalDateTime,

    @Column
    val idCliente : Long

)
fun Aposta.toClienteEntity() : ApostaEntity{
    return ApostaEntity(
        valor = valor,
        dataAposta = dataAposta,
        idCliente = idCliente
    )

}
