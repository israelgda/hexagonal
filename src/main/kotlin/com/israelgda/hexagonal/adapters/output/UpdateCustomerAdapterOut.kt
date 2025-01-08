package com.israelgda.hexagonal.adapters.output

import com.israelgda.hexagonal.adapters.input.toCustomer
import com.israelgda.hexagonal.adapters.output.mapper.toEntity
import com.israelgda.hexagonal.adapters.output.repository.CustomerRepository
import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.ports.output.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapterOut(
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {

    override fun update(customer: Customer) =
        customerRepository.save(customer.toEntity())
            .toCustomer()

}