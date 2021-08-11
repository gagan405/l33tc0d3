package `in`.minbox

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertArrayEquals

internal class TwoSumTest {

    @Test
    fun twoSum() {
        val actual = TwoSum.twoSum(intArrayOf(2,7,11,15), 9)
        assertArrayEquals(intArrayOf(0, 1), actual)
    }
}