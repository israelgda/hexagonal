package com.israelgda.hexagonal.adapters.output

import com.israelgda.hexagonal.adapters.output.mapper.toEntity
import com.israelgda.hexagonal.adapters.output.repository.CustomerRepository
import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.ports.output.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {
    override fun insert(customer: Customer) {
        customerRepository.save(customer.toEntity())
    }
}