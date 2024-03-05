package in.minbox.arrays;

import java.util.ArrayList;
import java.util.List;

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
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        java.util.Arrays.sort(nums);
        backtrackSubset(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrackSubset(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackSubset(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // 46
    // #backtrack #permutations
    // https://leetcode.com/problems/permutations/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackPermute(new ArrayList<>(), ans, nums);
        return ans;
    }

    public static void backtrackPermute(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrackPermute(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
