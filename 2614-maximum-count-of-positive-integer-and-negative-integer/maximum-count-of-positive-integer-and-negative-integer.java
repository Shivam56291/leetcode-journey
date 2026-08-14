class Solution {
    public int maximumCount(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int posIndex = -1;
        int negIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > 0) {
                posIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                negIndex = mid;
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        int positiveCount = (posIndex == -1) ? 0 : nums.length - posIndex;
        int negativeCount = negIndex + 1;

        return Math.max(negativeCount, positiveCount);
    }
}