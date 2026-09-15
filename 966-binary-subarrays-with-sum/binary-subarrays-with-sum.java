class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayWithSumAtMostK(nums, goal) - numSubarrayWithSumAtMostK(nums, goal - 1);
    }

    public int numSubarrayWithSumAtMostK(int[] nums, int goal) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        int n = nums.length;

        while (end < n) {
            sum += nums[end];
            while (start <= end && sum > goal) {
                sum -= nums[start++];
            }

            count += end - start + 1;
            end++;
        }

        return count;
    }
}