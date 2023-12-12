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

    @Test
    fun continuousSubArraySum() {
        val array = intArrayOf(23,2,4,6,7)
        assertTrue(Arrays.checkSubarraySum(array, 6))
    }

    @Test
    fun testProductExceptSelf() {
        val array = intArrayOf(1,2,3,4)
        val arr = Arrays.productExceptSelf(array)
        for (i in arr)
            println(i)
    }

    @Test
    fun testPlusOne() {
        assertArrayEquals(intArrayOf(1, 2, 3, 5), JArrays.plusOne(intArrayOf(1,2,3,4)))
        assertArrayEquals(intArrayOf(2, 0, 0), JArrays.plusOne(intArrayOf(1, 9, 9)))
        assertArrayEquals(intArrayOf(1), JArrays.plusOne(intArrayOf(0)))
    }


}