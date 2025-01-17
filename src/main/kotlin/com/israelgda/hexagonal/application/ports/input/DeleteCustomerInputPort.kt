package com.israelgda.hexagonal.application.ports.input

interface DeleteCustomerInputPort {
    fun deleteById(id: Long)
}