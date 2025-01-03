package com.israelgda.hexagonal.adapters.output.repository

import com.israelgda.hexagonal.adapters.output.repository.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<CustomerEntity, String> {
}