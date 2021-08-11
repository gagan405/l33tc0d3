package `in`.minbox

object UglyNumber {

    // problem number 263
    fun isUgly(n: Int): Boolean {
        if (n == 0) return false
        if (n == 1) return true

        var input = n

        val divisors = intArrayOf(2, 3, 5)

        for (d in divisors) {
            while (input % d == 0) {
                input /= d
                if (input == 1) return true
            }
        }

        return false
    }

}