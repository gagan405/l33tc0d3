package `in`.minbox

object IntReverse {
    // leetCode problem 7
    fun reverse(x: Int): Int {
        var input = Math.abs(x)
        var res = 0

        while (input > 0) {
            val digit = input % 10
            val prev = res
            res = prev * 10 + digit
            if ((res - digit) / 10 != prev) {
                // overflow
                return 0
            }
            input /= 10
        }

        return if (x < 0) -1 * res else res
    }
}