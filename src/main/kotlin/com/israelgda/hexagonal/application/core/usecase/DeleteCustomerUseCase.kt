package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.exceptions.NotFoundException
import com.israelgda.hexagonal.application.ports.input.DeleteCustomerInputPort
import com.israelgda.hexagonal.application.ports.output.DeleteCustomerOutputPort
import com.israelgda.hexagonal.application.ports.output.FindCustomerOutputPort

class DeleteCustomerUseCase(
    private val findCustomerOutputPort: FindCustomerOutputPort,
    private val deleteCustomerOutputPort: DeleteCustomerOutputPort
): DeleteCustomerInputPort {
    override fun deleteById(id: Long) {
        val customerRetrivied = findCustomerOutputPort.findById(id)
            ?: throw NotFoundException("Customer not found for id: $id")

        try {
            deleteCustomerOutputPort.deleteById(customerRetrivied.id!!)
        } catch (exception: RuntimeException){
            throw RuntimeException("Erro inesperado!")
        }
    }
}