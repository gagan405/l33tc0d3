package `in`.minbox.math

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PowerTest {

    @Test
    fun isPowerOfTwo() {
        assertTrue(Power.isPowerOfTwo(4))
        assertFalse(Power.isPowerOfTwo(0))
        assertFalse(Power.isPowerOfTwo(-1))
        assertTrue(Power.isPowerOfTwo(1))
        //assertTrue(Power.isPowerOfTwo(-4))
    }
}
