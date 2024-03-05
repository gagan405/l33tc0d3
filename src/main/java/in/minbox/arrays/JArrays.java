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

    // https://leetcode.com/problems/partition-array-for-maximum-sum/
    // 1043
    // #dp, #arrays
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, 0);

        for (int start = n - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(n, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                // Store the maximum of all options for the current subarray.
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }

}
