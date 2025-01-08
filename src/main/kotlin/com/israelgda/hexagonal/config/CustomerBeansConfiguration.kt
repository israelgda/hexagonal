package com.israelgda.hexagonal.config

import com.israelgda.hexagonal.application.core.usecase.FindCustomerUseCase
import com.israelgda.hexagonal.application.core.usecase.InsertCustomerUserCase
import com.israelgda.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.israelgda.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort
import com.israelgda.hexagonal.application.ports.output.FindCustomerOutputPort
import com.israelgda.hexagonal.application.ports.output.InsertCustomerOutputPort
import com.israelgda.hexagonal.application.ports.output.UpdateCustomerOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerBeansConfiguration {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapterOut: FindAddressByZipCodeOutputPort,
        insertCustomerAdapterOut: InsertCustomerOutputPort
    ) = InsertCustomerUserCase(
            findAddressByZipCodeAdapterOut,
            insertCustomerAdapterOut,
        )

    @Bean
    fun findCustomer(
        findCustomerAdapterOut: FindCustomerOutputPort
    ) = FindCustomerUseCase(
        findCustomerAdapterOut,
    )

    @Bean
    fun updateCustomer(
        findCustomerAdapterOut: FindCustomerOutputPort,
        findAdressByZipCodeAdapterOut: FindAddressByZipCodeOutputPort,
        updateCustomerAdapterOut: UpdateCustomerOutputPort,
    ) = UpdateCustomerUseCase(
        findCustomerAdapterOut,
        findAdressByZipCodeAdapterOut,
        updateCustomerAdapterOut,
    )


}