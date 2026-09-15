class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWindow = Integer.MAX_VALUE;
        int currSum = 0;

        int low = 0;
        int high = 0;

        while (high < nums.length) {
            currSum += nums[high++];

            while (currSum >= target) {
                int currWindowSize = high - low;
                minLenWindow = Math.min(minLenWindow, currWindowSize);

                currSum -= nums[low++];
            }
        }

        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}