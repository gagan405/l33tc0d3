package `in`.minbox

import kotlin.math.min

object SubArray {

    // solves problem 1590
    fun minSubArrayWithSum(nums: IntArray, targetDivisor: Int): Int {
        val diffFromTarget = getSumModuloN(nums, targetDivisor)
        if (diffFromTarget == 0) return 0

        val m: MutableMap<Int, Int> = HashMap()
        m[0] = -1

        var prefix = 0
        var ans = nums.size

        for (i in nums.indices) {
            prefix = (prefix + nums[i]) % targetDivisor
            var search = (prefix - diffFromTarget) % targetDivisor

            /**
             * What we are doing here is this:
             * Prefix is already a mod value calculated above
             * search is another mod value
             *
             * 'search' can thus be negative. We need to make it positive because
             * we are keeping 'prefix' as the hashMap keys which will never be -ve.
             * Otherwise, we will potentially miss out certain sub-arrays with the target sum.
             *
             * In order to do that, what we need is a positive number with the same mod value
             * as of the -ve 'search'.
             *
             * So, we just add the targetDivisor there.
             *
             * https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-addition-and-subtraction
             *
             */
            if (search < 0)
                search += targetDivisor

            if (m.containsKey(search)) {
                ans = min(ans, i - m[search]!!)
            }
            m[prefix] = i
        }

        return if (ans == nums.size) -1 else ans
    }

    /**
     * This returns the number that has to be removed from the input array of
     * ints so that the sum of the array will be divisible by targetDivisor.
     *
     * So we just take the sum of the whole array and do a modulo operation.
     * We can also do the mod while adding each number, in order to avoid any potential
     * integer overflow.
     *
     * https://math.stackexchange.com/a/2164001/55301
     */
    fun getSumModuloN(nums: IntArray, targetDivisor: Int): Int {
        var need = 0

        for (i in nums)
            need = (need + i) % targetDivisor

        if (need == 0) return 0
        else return need
    }
}