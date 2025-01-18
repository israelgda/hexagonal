package com.israelgda.hexagonal.archtecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["com.israelgda.hexagonal"])
class LayeredArchitectureTest {

    @ArchTest
    val `layered architecture test` = layeredArchitecture()
        .consideringAllDependencies()
        .layer("AdaptersIn").definedBy("..adapters.input..")
        .layer("AdaptersOut").definedBy("..adapters.output..")
        .layer("UseCase").definedBy("..application.core.usecase..")
        .layer("PortsIn").definedBy("..application.ports.input..")
        .layer("PortsOut").definedBy("..application.ports.output..")
        .layer("Config").definedBy("..config..")
        .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
}