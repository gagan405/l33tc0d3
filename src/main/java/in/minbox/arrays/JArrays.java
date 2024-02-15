package in.minbox.arrays;

public class JArrays {

    // https://leetcode.com/problems/plus-one/description/
    public static int[] plusOne(int[] digits) {
        
        int idx;
        for (idx = digits.length - 1; idx >=0 && digits[idx] == 9; idx--) {
            digits[idx] = 0;
        }

        if (idx >= 0) {
            digits[idx]++;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

}
