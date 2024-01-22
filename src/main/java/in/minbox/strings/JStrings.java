package in.minbox.strings;

public class JStrings {
    // https://leetcode.com/problems/multiply-strings/description/
    public static String multiply(String num1, String num2) {
        int[] sb = new int[num1.length() + num2.length()];

        for (int i = num1.length() -1; i >= 0; i--) {
            for (int j = num2.length() -1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = sb[i + j + 1] + mul;
                sb[i + j + 1] = sum % 10;
                sb[i + j] = sb[i +j] + sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int p : sb) {
            if(!(stringBuilder.length() == 0 && p == 0))
                stringBuilder.append(p);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static String removeDuplicatesAndReturnLexicographic(String s) {
        int[] count = new int[26];
        int pos = 0;

        // first get the count of all chars
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // get the smallest alphabet position: smallest or unique whichever is earlier
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            // check if this is the only occurrence
            if (--count[s.charAt(i) - 'a'] == 0) break;
        }

        // return the smallest char + rest of the string worked on recursively
        // replaceAll - O(n)
        return s.length() == 0 ? "":
                s.charAt(pos) + removeDuplicatesAndReturnLexicographic(s.substring(pos + 1)
                        .replaceAll(String.valueOf(s.charAt(pos)), ""));
    }
}
