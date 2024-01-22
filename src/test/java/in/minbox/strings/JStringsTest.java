package in.minbox.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JStringsTest {

    @Test
    void removeDuplicatesAndReturnLexicographic() {
        assertEquals("abc", JStrings.removeDuplicatesAndReturnLexicographic("bcabc"));
        //assertEquals("acdb", JStrings.removeDuplicatesAndReturnLexicographic("cbacdcbc"));
        //assertEquals("dab", JStrings.removeDuplicatesAndReturnLexicographic("ddaabba"));
    }
}