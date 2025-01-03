package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.ports.input.InsertCustomerInputPort
import com.israelgda.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort
import com.israelgda.hexagonal.application.ports.output.InsertCustomerOutputPort

class InsertCustomerUserCase(
    private val findAdressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            val address = findAdressByZipCodeOutputPort.find(zipCode)
            with(customer){
                street = address.street
                city = address.city
                state = address.state
            }
        }.let {
            insertCustomerOutputPort.insert(it)
        }
    }
}