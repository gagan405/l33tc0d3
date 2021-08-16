package `in`.minbox.math

object Power {
    // problem 231
    fun isPowerOfTwo(x: Int): Boolean {
        if ((x == 0) || (x == -1)) return false

        return if (x > 0) {
            (x and (x - 1)) == 0
        } else {
            (x and (x + 1)) == 0
        }

    }
}