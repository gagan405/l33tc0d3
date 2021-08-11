package `in`.minbox

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntReverseTest {

    @Test
    fun reverse() {
        val reversed = IntReverse.reverse(123)
        assertEquals(321, reversed)

        assertEquals(-321, IntReverse.reverse(-123))
        assertEquals(0, IntReverse.reverse(1534236469))
    }
}