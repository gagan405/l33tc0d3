package `in`.minbox

object TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        /**
         * Map to store the index of each number
         */
        val indices = HashMap<Int, Int>()
        for ((i, v) in nums.withIndex()) {
            // see if the complimenting number is there in the map
            if (indices.containsKey(target - v)) {
                return intArrayOf(indices.get(target - v)!!, i)
            } else {
                // else update the map
                indices.put(v, i)
            }
        }
        return intArrayOf()
    }
}