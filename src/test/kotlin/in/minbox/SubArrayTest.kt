package `in`.minbox

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubArrayTest {

    @Test
    fun minSubArrayWithSum() {
        assertEquals(1, SubArray.minSubArrayWithSum(intArrayOf(3, 1, 4, 2), 6))
    }
}