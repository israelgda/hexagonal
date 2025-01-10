package com.israelgda.hexagonal.application.core.usecase

import com.israelgda.hexagonal.application.core.domain.Customer
import com.israelgda.hexagonal.application.core.exceptions.ClientErrorException
import com.israelgda.hexagonal.application.core.exceptions.CpfAlreadyRegisteredException
import com.israelgda.hexagonal.application.ports.input.InsertCustomerInputPort
import com.israelgda.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort
import com.israelgda.hexagonal.application.ports.output.InsertCustomerOutputPort
import feign.FeignException
import jakarta.validation.ConstraintViolationException
import org.postgresql.util.PSQLException
import org.springframework.dao.DataIntegrityViolationException

class InsertCustomerUserCase(
    private val findAdressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        try {
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
        } catch (e: ConstraintViolationException) {
            throw CpfAlreadyRegisteredException("CPF já cadastrado na base.")
        } catch (e: FeignException) {
            throw ClientErrorException("Erro no processamento da chamada ao client.")
        }
    }
}