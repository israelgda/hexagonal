package com.israelgda.hexagonal.config

import com.israelgda.hexagonal.adapters.output.FindAddressByZipCodeAdapter
import com.israelgda.hexagonal.adapters.output.InsertCustomerAdapter
import com.israelgda.hexagonal.application.core.usecase.InsertCustomerUserCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUserCase(
            findAddressByZipCodeAdapter,
            insertCustomerAdapter,
        )


}