package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Cliente

interface CreateClientUseCase {

    fun saveCliente(cliente: Cliente)

}