package in.minbox.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JStrings {

    private static char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

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

    public static int minStickers(String[] stickers, String target) {
        // Optimization 1: Maintain frequency only for characters present in target
        int[] targetNaiveCount = new int[26];
        for(char c: target.toCharArray()) targetNaiveCount[c - 'a']++;
        int[] index = new int[26];
        int N = 0;  // no of distinct characters in target
        for(int i = 0; i < 26; i++) index[i] = targetNaiveCount[i] > 0 ? N++ : -1;
        int[] targetCount = new int[N];
        int t = 0;
        for(int c: targetNaiveCount) if(c > 0) {
            targetCount[t++] = c;
        }
        int[][] stickersCount = new int[stickers.length][N];
        for(int i = 0; i < stickers.length; i++) {
            for(char c: stickers[i].toCharArray()) {
                int j = index[c - 'a'];
                if(j >= 0) stickersCount[i][j]++;
            }
        }
        // Optimization 2: Remove stickers dominated by some other sticker
        int start = 0;
        for(int i = 0; i < stickers.length; i++) {
            for(int j = start; j < stickers.length; j++) if(j != i) {
                int k = 0;
                while(k < N && stickersCount[i][k] <= stickersCount[j][k]) k++;
                if(k == N) {
                    int[] tmp = stickersCount[i];
                    stickersCount[i] = stickersCount[start];
                    stickersCount[start++] = tmp;
                    break;
                }
            }
        }
        // Perform BFS with target as source and an empty string as destination
        Queue<int[]> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Q.add(targetCount);
        int steps = 0;
        while(!Q.isEmpty()) {
            steps++;
            int size = Q.size();
            while(size-- > 0) {
                int[] freq = Q.poll();
                String cur = toString(freq);
                if(visited.add(cur)) {
                    // Optimization 3: Only use stickers that are capable of removing first character from current string
                    int first = cur.charAt(0) - 'a';
                    for(int i = start; i < stickers.length; i++) if(stickersCount[i][first] != 0) {
                        int[] next = freq.clone();
                        for(int j = 0; j < N; j++) next[j] = Math.max(next[j] - stickersCount[i][j], 0);
                        if(empty(next)) return steps;
                        Q.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private static boolean empty(int[] freq) {
        for(int f: freq) if(f > 0) return false;
        return true;
    }
    private static String toString(int[] freq) {
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int f: freq) {
            while(f-- > 0) sb.append(c);
            c++;
        }
        return sb.toString();
    }

    // Create a hash value
    public static String getHash(String s) {
        char[] chars = s.toCharArray();

        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        return String.valueOf(chars);
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
