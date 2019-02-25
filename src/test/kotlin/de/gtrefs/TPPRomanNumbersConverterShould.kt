package de.gtrefs

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class TPPRomanNumbersConverterShould {
    @Test
    fun `convert 1 to I`(){
        val actual = convertToRoman(1)
        assertThat(actual, equalTo("I"))
        // TPP: [] -> nil is forbidden by Kotlin
        // TPP: nil -> constant let's this test pass
    }

    @Test
    fun `convert 2 to II`(){
        val actual = convertToRoman(2)
        assertThat(actual, equalTo("II"))
        // TPP: unconditional -> conditional
    }

    @Test
    fun `convert 3 to III`(){
        val actual = convertToRoman(3);
        assertThat(actual, equalTo("III"))
        // TPP: Scalar -> array
    }

    @Test
    fun `convert 4 to IV`(){
        val actual = convertToRoman(4);
        assertThat(actual, equalTo("IV"))
        // TPP: Scalar -> array
    }

    @Test
    fun `convert 5 to V`(){
        val actual = convertToRoman(5)
        assertThat(actual, equalTo("V"))
        // TPP: Scalar -> array
    }

    @Test
    fun `convert 6 to VI`(){
        val actual = convertToRoman(6)
        assertThat(actual, equalTo("VI"))
        // TPP: Scalar -> array
    }

    @Test
    fun `convert 7 to VII`(){
        val actual = convertToRoman(7)
        assertThat(actual, equalTo("VII"))
        // Duplication
        // TPP: unconditional -> conditional
        // TPP: Scalar -> array
        // TPP: Variable -> mutation
    }

    @Test
    fun `convert 8 to VIII`(){
        val actual = convertToRoman(8)
        assertThat(actual, equalTo("VIII"))
    }

    @Test
    fun `convert 9 to IX`(){
        val actual = convertToRoman(9)
        assertThat(actual, equalTo("IX"))
        // Duplication
        // TPP: If -> loop
        // TPP: Scalar -> Array
        // TPP: Array -> Container
    }

    @Test
    fun `convert 10 to X`(){
        val actual = convertToRoman(10)
        assertThat(actual, equalTo("X"))
        // TPP: Statement -> tail recursion
        // TPP: Constant scalar
    }


    fun convertToRoman(i: Int):String {
        val mapping = mapOf(10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")
        tailrec fun toRoman(number: Int, arabic: Int, romanLiteral: String, result: String = ""): Pair<Int, String> = when {
            number / arabic <= 0 -> number to result
            else -> toRoman(number - arabic, arabic, romanLiteral, romanLiteral + result)
        }

        return mapping.asSequence().fold(i to ""){(number, converted), (arabic, romanLiteral) ->
            val (rest, roman) = toRoman(number, arabic, romanLiteral)
            rest to converted + roman
        }.second
    }

}
