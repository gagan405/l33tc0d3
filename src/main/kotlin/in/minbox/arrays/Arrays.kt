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
}