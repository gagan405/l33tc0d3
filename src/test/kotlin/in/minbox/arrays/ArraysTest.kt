package `in`.minbox.arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArraysTest {

    @Test
    fun rotate() {
        val array = intArrayOf(1,2,3,4,5,6,7)
        Arrays.rotate1(array, 1)
        assertArrayEquals(intArrayOf(7,1,2,3,4,5,6), array)
    }

    @Test
    fun rotate2() {
        val array = intArrayOf(1,2,3,4,5,6,7)
        Arrays.rotate2(array, 3)
        assertArrayEquals(intArrayOf(5,6,7,1,2,3,4), array)
    }
}