package com.israelgda.hexagonal.application.ports.output

import com.israelgda.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer): Customer
}