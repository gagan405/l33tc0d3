package `in`.minbox.math

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


    // problem number 264
    // Apparently DynamicProgramming solution.. better explained here:
    // https://math.stackexchange.com/a/198101/55301
    fun nthUglyNumber(n: Int): Int {
        if (n == 1) return 1
        return nthUglyNumber(n - 1, 2, 3, 5)
    }


    /**
     * Returns from 1-indexed array
     * i.e., 1, 2, 3, 4, 5 ...
     *
     */
    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val numbers: MutableList<Int> = ArrayList()
        numbers.add(1)

        var ca = 0
        var cb = 0
        var cc = 0

        var next: Int

        var idx = 1
        while (idx <= n) {
            next = minOf(a * numbers[ca], b * numbers[cb], c * numbers[cc])
            if (next == a * numbers[ca]) ca++
            if (next == b * numbers[cb]) cb++
            if (next == c * numbers[cc]) cc++

            numbers.add(next)
            idx++
        }

        return numbers.last()
    }
}