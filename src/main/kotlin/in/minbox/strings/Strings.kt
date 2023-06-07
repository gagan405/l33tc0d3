package `in`.minbox.strings

object Strings {

    private val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    private fun isVowel(c: Char): Boolean {
        return c in vowels
    }

    fun reverseVowels(string: String): String {
        val arr = string.toCharArray()
        var start = 0
        var end = string.length -1

        while (start < end) {
            if (isVowel(arr[start]) && isVowel(arr[end])) {
                val ch = arr[start]
                arr[start] = arr[end]
                arr[end] = ch
                start++
                end--
            } else if (isVowel(arr[start])) {
                end--
            } else {
                start++
            }
        }

        return String(arr)
    }

}