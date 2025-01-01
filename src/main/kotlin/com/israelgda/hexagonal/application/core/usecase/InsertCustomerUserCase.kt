package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.ports.output.FInAddressByZipCodeOutputPort
import com.israelgda.hexagonal.application.ports.output.InsertCustomerOutputPort

class InsertCustomerUserCase(
    val findAdressByZipCodeOutputPort: FInAddressByZipCodeOutputPort,
    val insertCustomerOutputPort: InsertCustomerOutputPort,
) {

    fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAdressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
        }
    }
}