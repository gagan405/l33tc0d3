package `in`.minbox.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UglyNumberTest {

    @Test
    fun isUgly() {
        assertTrue(UglyNumber.isUgly(30))
        assertFalse(UglyNumber.isUgly(49))
    }

    @Test
    fun nthUglyNumber() {
        assertEquals(12, UglyNumber.nthUglyNumber(10))
    }


    @Test
    fun nthUglyNumberGeneric() {
        assertEquals(4, UglyNumber.nthUglyNumber(3, 2, 3, 5))
        assertEquals(6, UglyNumber.nthUglyNumber(4, 2, 3, 4))
    }
}