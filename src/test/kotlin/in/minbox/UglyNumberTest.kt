package `in`.minbox

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UglyNumberTest {

    @Test
    fun isUgly() {
        assertTrue(UglyNumber.isUgly(30))
        assertFalse(UglyNumber.isUgly(49))
    }
}