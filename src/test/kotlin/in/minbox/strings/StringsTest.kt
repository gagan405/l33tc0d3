package `in`.minbox.strings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringsTest {

    @Test
    fun reverseVowels() {
        assertEquals("holle", Strings.reverseVowels("hello"));
    }

}