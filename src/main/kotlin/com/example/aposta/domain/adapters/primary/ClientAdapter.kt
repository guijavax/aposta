package com.example.aposta.domain.adapters.primary

import com.example.aposta.application.port.input.ClientUseCase
import com.example.aposta.domain.model.Cliente
import com.example.aposta.domain.model.toCliente
import com.example.aposta.infra.entity.ClienteEntity
import com.example.aposta.infra.entity.toClienteEntity
import com.example.aposta.infra.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientAdapter : ClientUseCase {

    @Autowired
    lateinit var clientRepository: ClientRepository


    override fun saveCliente(cliente: Cliente) : ClienteEntity {
        val clienteEntity = cliente.toClienteEntity()

        return clientRepository.save(clienteEntity)
    }

    override fun deletar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun search(cpf: String): Cliente {
        TODO("Not yet implemented")
    }

    override fun atualiza(client: Cliente) {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Cliente> {
        val listCliente = clientRepository.findAll()
        return listCliente.map { it.toCliente() }
    }
}