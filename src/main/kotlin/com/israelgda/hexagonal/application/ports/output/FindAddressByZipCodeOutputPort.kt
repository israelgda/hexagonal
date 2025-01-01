package com.israelgda.hexagonal.application.ports.output

import com.israelgda.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}