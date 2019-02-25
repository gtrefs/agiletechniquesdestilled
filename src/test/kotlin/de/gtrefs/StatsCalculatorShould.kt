/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package de.gtrefs

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class StatsCalculatorShould {
    @TestFactory
    fun `compute min value`() =
        listOf(-2 to listOf(1, 2, -2, 0, 3), -3 to listOf(1, -3), -4 to listOf(-4)).map {
            DynamicTest.dynamicTest("as ${it.first} for sequence ${it.second}"){
                val min = calculateMin(it.second)
                assertThat(min, equalTo(it.first))
            }
        }
}

private fun calculateMin(sequence: List<Int>): Int = sequence.min()!!
