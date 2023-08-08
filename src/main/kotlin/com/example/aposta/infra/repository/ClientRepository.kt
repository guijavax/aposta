package com.example.aposta.infra.repository

import com.example.aposta.infra.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity, Long> {
}