package com.israelgda.hexagonal.config

import com.israelgda.hexagonal.adapters.output.FindAddressByZipCodeAdapterOut
import com.israelgda.hexagonal.adapters.output.FindCustomerAdapterOut
import com.israelgda.hexagonal.adapters.output.InsertCustomerAdapterOut
import com.israelgda.hexagonal.application.core.usecase.FindCustomerUseCase
import com.israelgda.hexagonal.application.core.usecase.InsertCustomerUserCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerBeansConfiguration {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapterOut: FindAddressByZipCodeAdapterOut,
        insertCustomerAdapterOut: InsertCustomerAdapterOut
    ) = InsertCustomerUserCase(
            findAddressByZipCodeAdapterOut,
            insertCustomerAdapterOut,
        )

    @Bean
    fun findCustomer(
        findCustomerAdapterOut: FindCustomerAdapterOut
    ) = FindCustomerUseCase(
        findCustomerAdapterOut,
    )


}