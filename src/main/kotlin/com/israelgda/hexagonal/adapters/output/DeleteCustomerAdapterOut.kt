package com.israelgda.hexagonal.adapters.output

import com.israelgda.hexagonal.adapters.output.repository.CustomerRepository
import com.israelgda.hexagonal.application.ports.output.DeleteCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerAdapterOut(
    private val customerRepository: CustomerRepository
): DeleteCustomerOutputPort {
    override fun deleteById(id: Long) {
        customerRepository.deleteById(id)
    }
}