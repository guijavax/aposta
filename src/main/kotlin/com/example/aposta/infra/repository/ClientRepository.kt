package com.example.aposta.infra.repository

import com.example.aposta.infra.entity.ClienteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClienteEntity, Long> {
}