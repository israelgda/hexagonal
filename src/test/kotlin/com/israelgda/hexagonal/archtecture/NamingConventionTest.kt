package com.israelgda.hexagonal.archtecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.israelgda.hexagonal"])
class NamingConventionTest {

    @ArchTest
    val `consumer resides only on consumer package` = classes()
        .that()
        .haveNameMatching(".*Consumer")
        .should()
        .resideInAPackage("..adapters.input.consumer")

    @ArchTest
    val `should be sufixec consumer` = classes()
        .that()
        .resideInAPackage("..consumer")
        .should()
        .haveSimpleNameEndingWith("Consumer")
}