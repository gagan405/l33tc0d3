package `in`.minbox.strings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringsTest {

    @Test
    fun reverseVowels() {
        assertEquals("holle", Strings.reverseVowels("hello"));
    }

    @Test
    fun multiply() {
        val string = JStrings.multiply("99", "99")
        assertEquals("9801", string)
    }

    @Test
    fun countStickers() {
        val stickers = JStrings.minStickers(arrayOf("with","example","science"), "thehat")
        assertEquals(3, stickers)
    }

    @Test
    fun getHash() {
        val hash = JStrings.getHash("hello")
        assertEquals("axeeh", hash)

        assertEquals("abcd", JStrings.getHash("abcd"))
    }
}