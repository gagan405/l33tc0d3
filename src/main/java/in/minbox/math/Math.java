package in.minbox.math;

import java.util.Arrays;

public class Math {
    public void rotate(int[][] matrix) {
        int start = 0;

        for (int i = start; i < matrix.length/2; i++) {
            for (int j = i; j < getRightBoundary(i, matrix.length); j++) {
                swap(matrix, j, matrix.length - i - 1, matrix[i][j], 0);
            }
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }

        return java.lang.Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
    }

    private void swap(int[][] matrix, int toi, int toj, int what, int count) {
        if (count == 4) return;
        int tmp = matrix[toi][toj];
        matrix[toi][toj] = what;
        swap(matrix, toj, matrix.length - toi - 1, tmp, ++count);
    }

    private int getRightBoundary(int layer, int size) {
        return size - 1 - layer;
    }

}
