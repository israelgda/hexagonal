package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.core.exceptions.NotFoundException
import com.israelgda.hexagonal.application.ports.input.UpdateCustomerInputPort
import com.israelgda.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort
import com.israelgda.hexagonal.application.ports.output.FindCustomerOutputPort
import com.israelgda.hexagonal.application.ports.output.UpdateCustomerOutputPort
import jakarta.validation.ConstraintViolationException

class UpdateCustomerUseCase(
    private val findCustomerOutputPort: FindCustomerOutputPort,
    private val findAdressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
): UpdateCustomerInputPort {

    override fun update(id: Long, customerRequested: Customer, zipCode: String): Customer {
        val customerRetrivied =
            findCustomerOutputPort.findById(id)
                ?: throw NotFoundException("Customer not found for id: $id")

        try {
            customerRetrivied.apply {
                val address = findAdressByZipCodeOutputPort.find(zipCode)

                with(customerRetrivied){
                    name = customerRequested.name
                    street = address.street
                    city = address.city
                    state = address.state
                    cpf = customerRequested.cpf
                }
            }.let {
                return updateCustomerOutputPort.update(it)
            }
        } catch (e: ConstraintViolationException) {
            throw RuntimeException("CPF já cadastrado na base.")
        }
    }

}