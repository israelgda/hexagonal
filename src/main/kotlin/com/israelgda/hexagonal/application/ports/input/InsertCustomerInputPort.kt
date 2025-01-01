package com.israelgda.hexagonal.application.ports.input

import com.israelgda.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}