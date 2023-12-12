package `in`.minbox.bits

object Bits {

    // LeetCode 190
    fun reverseBinary(n : Int): Int {
        var y = 0
        var z: Int = n

        for (count in 1..32) {
            y = y or (z and 1)
            z = z shr 1
            if (count < 32) y = y shl 1
        }

        return y
    }
}