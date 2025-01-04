package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.exceptions.NotFoundException
import com.israelgda.hexagonal.application.ports.input.FindCustomerInputPort
import com.israelgda.hexagonal.application.ports.output.FindCustomerOutputPort

class FindCustomerUseCase(
    private val findCustomerOutputPort: FindCustomerOutputPort
): FindCustomerInputPort {

    override fun findById(id: Long)
        = findCustomerOutputPort.findById(id)
            ?: throw NotFoundException("Customer not found for id: $id")

}