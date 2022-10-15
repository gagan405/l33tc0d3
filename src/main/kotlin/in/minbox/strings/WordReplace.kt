package `in`.minbox.strings

import `in`.minbox.Trie
import `in`.minbox.alphatrie.CaseInsensitiveAlphaTrie

object WordReplace {
    // solves problem 648
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val trie: Trie = CaseInsensitiveAlphaTrie()
        dictionary.forEach { trie.add(it) }

        val tokens = sentence.split(" ").toTypedArray()
        for (i in tokens.indices) {
            val prefix = trie.findShortestPrefix(tokens[i])
            if(prefix.isPresent) {
                tokens[i] = prefix.get()
            }
        }

        return tokens.joinToString(separator = " ")
    }
}
