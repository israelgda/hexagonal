package com.israelgda.hexagonal.application.ports.output

interface DeleteCustomerOutputPort {
    fun deleteById(id: Long)
}