package de.gtrefs

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class RomanNumbersConverterShould {
    @Test
    fun `convert 1 to I`(){
        val expected = convertToRoman(1);
        assertThat(expected, equalTo("I"))
    }

    @Test
    fun `convert 2 to II`(){
        val expected = convertToRoman(2);
        assertThat(expected, equalTo("II"))
    }

    @Test
    fun `convert 3 to III`(){
        val expected = convertToRoman(3);
        assertThat(expected, equalTo("III"))
    }

    @Test
    fun `convert 5 to V`(){
        val expected = convertToRoman(5);
        assertThat(expected, equalTo("V"))
    }

    @Test
    fun `convert 6 to VI`(){
        val expected = convertToRoman(6);
        assertThat(expected, equalTo("VI"))
    }

    @Test
    fun `convert 7 to VII`(){
        val expected = convertToRoman(7);
        assertThat(expected, equalTo("VII"))
    }

    @Test
    fun `convert 4 to IV`(){
        val expected = convertToRoman(4);
        assertThat(expected, equalTo("IV"))
    }

    @Test
    fun `convert 8 to VIII`(){
        val expected = convertToRoman(8);
        assertThat(expected, equalTo("VIII"))
    }

    @Test
    fun `convert 9 to IX`(){
        val expected = convertToRoman(9);
        assertThat(expected, equalTo("IX"))
    }

    @Test
    fun `convert 10 to X`(){
        val expected = convertToRoman(10);
        assertThat(expected, equalTo("X"))
    }

    @Test
    fun `convert 846 to DCCCXLVI`(){
        val expected = convertToRoman(846);
        assertThat(expected, equalTo("DCCCXLVI"))
    }

    @Test
    fun `convert 1999 to MCMXCIX`(){
        val expected = convertToRoman(1999);
        assertThat(expected, equalTo("MCMXCIX"))
    }
}

private fun convertToRoman(i: Int): String = when {
    i / 1000 > 0 -> "M${convertToRoman(i - 1000)}"
    i / 900 > 0 -> "CM${convertToRoman(i - 900)}"
    i / 500 > 0 -> "D${convertToRoman(i - 500)}"
    i / 400 > 0 -> "CD${convertToRoman(i - 400)}"
    i / 100 > 0 -> "C${convertToRoman(i - 100)}"
    i / 90 > 0 -> "XC${convertToRoman(i - 90)}"
    i / 50 > 0 -> "L${convertToRoman(i - 50)}"
    i / 40 > 0 -> "XL${convertToRoman(i - 40)}"
    i / 10 > 0 -> "X${convertToRoman(i - 10)}"
    i / 9 > 0 -> "IX${convertToRoman(i - 9)}"
    i / 5 > 0 -> "V${convertToRoman(i - 5)}"
    i / 4 > 0 -> "IV${convertToRoman(i - 4)}"
    else -> (1 .. i).fold("") { acc, _ -> acc + "I"}
}