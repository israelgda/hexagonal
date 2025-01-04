package com.israelgda.hexagonal.adapters.output

import com.israelgda.hexagonal.adapters.input.toCustomer
import com.israelgda.hexagonal.adapters.output.repository.CustomerRepository
import com.israelgda.hexagonal.application.ports.output.FindCustomerOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerAdapterOut(
    private val customerRepository: CustomerRepository
): FindCustomerOutputPort {

    override fun findById(id: Long)
        = customerRepository.findById(id)
            .getOrNull()
            ?.toCustomer()

}