package com.israelgda.hexagonal.application.ports.output

import com.israelgda.hexagonal.application.core.domain.Address

interface FInAddressByZipCodeOutputPort {

    fun find(ziCode: String): Address
}