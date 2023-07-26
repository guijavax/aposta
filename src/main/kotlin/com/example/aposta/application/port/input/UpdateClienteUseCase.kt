package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Cliente

interface UpdateClienteUseCase {

    fun atualiza(client : Cliente)
}