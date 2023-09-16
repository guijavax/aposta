package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Aposta

interface ApostaUseCase {

    fun saveAposta(aposta : Aposta)
}