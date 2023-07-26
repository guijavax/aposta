package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Cliente

interface FindClientUseCase {

    fun search(cpf : String) : Cliente
}