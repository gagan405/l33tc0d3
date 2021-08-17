package `in`.minbox.strings

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WordReplaceTest {

    @Test
    fun replaceWords() {
        var s = WordReplace.replaceWords(listOf("cat","bat","rat"), "the cattle was rattled by the battery")
        assertEquals("the cat was rat by the bat", s)

        s = WordReplace.replaceWords(listOf("a","b","c"), "aadsfasf absbs bbab cadsfafs")
        assertEquals("a a b c", s)

        s = WordReplace.replaceWords(listOf("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa")
        assertEquals("a a a a a a a a bbb baba a", s)

        s = WordReplace.replaceWords(listOf("ac","ab"), "it is abnormal that this solution is accepted")
        assertEquals("it is ab that this solution is ac", s)
    }
}