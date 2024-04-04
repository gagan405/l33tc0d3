package `in`.minbox.arrays

object Arrays {
    // problem 189
    // uses the naive method of O(n) algorithm to move all elements
    fun rotate1(nums: IntArray, k: Int) {
        var count = 0
        val length = nums.size
        while (count < k) {
            for (i in 0..length-2) {
                val temp = nums[nums.size - (2 + i)]
                nums[nums.size - (2 + i)] = nums[nums.size - (1 + i)]
                nums[nums.size - (1 + i)] = temp
            }
            count++
        }
    }


    fun rotate2(nums: IntArray, k: Int) {
        if (k == 0) return

        val n: Int = nums.size
        // in case the rotating factor is
        // greater than array length
        val d = k % n

        reverse(nums, nums.size - d, nums.size - 1)
        reverse(nums, 0, nums.size - d - 1)
        reverse(nums, 0, nums.size - 1)
    }


    fun reverse(nums: IntArray, start: Int, end: Int) {
        var temp: Int
        var s = start
        var e = end
        while(s < e) {
            temp = nums[s]
            nums[s] = nums[e]
            nums[e] = temp
            s++
            e--
        }
    }


    // Leetcode 238
    fun productExceptSelf(nums: IntArray): IntArray {
        val temp = IntArray(nums.size)
        temp[0] = 1
        for (i in 1 until temp.size) {
            temp[i] = nums[i - 1] * temp[i - 1]
        }
        var runningProduct = nums[nums.size - 1]
        for (i in temp.size - 2 downTo 0) {
            temp[i] = runningProduct * temp[i]
            runningProduct *= nums[i]
        }
        return temp
    }



    // Leetcode 532
    // https://leetcode.com/problems/k-diff-pairs-in-an-array/
    fun findPairs(nums: IntArray, k: Int): Int {
        val map: MutableMap<Int, Int> = HashMap()
        for (num in nums) map[num] = map.getOrDefault(num, 0) + 1
        var result = 0
        for (i in map.keys) if (k > 0 && map.containsKey(i + k) || k == 0 && map[i]!! > 1) result++
        return result
    }


    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map: MutableMap<Int, Int> = HashMap()
        map[0] = -1
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (k != 0) {
                sum %= k
            }
            if (map.containsKey(sum)) {
                if (i - map[sum]!! > 1) return true
            } else {
                map[sum] = i
            }
        }
        return false
    }

    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        var res = 0
        // we create an array where we setup the expected time of arrival at the target, for each position
        // for example: target 100; cars:[0, 2] speed : [4, 2]
        // times will be : [25, 0, 49]
        val timeArr = DoubleArray(target)
        for (i in position.indices) {
            timeArr[position[i]] = (target - position[i]).toDouble() / speed[i]
        }
        // since a faster car is stuck with a slower one, we traverse the timeArray backwards and make the faster ones
        // slower. In above case [25, 0, 49]; even if the car at position 0 can ideally reach the destination sooner,
        // it will get stuck with the slow moving traffic ahead, so we would consider it as single fleet.
        var prev = 0.0
        for (i in target - 1 downTo 0) {
            val cur = timeArr[i]
            if (cur > prev) {
                prev = cur
                res++
            }
        }
        return res
    }
}