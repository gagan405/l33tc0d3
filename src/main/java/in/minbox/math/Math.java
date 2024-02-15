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

    // leetcode 64 : https://leetcode.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += java.lang.Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    // leetcode: 48 https://leetcode.com/problems/rotate-image/description/
    public void rotate2(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp ;
                temp =  matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix.length / 2; j++){
                int temp = 0 ;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
