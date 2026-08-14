class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int leftElements = mid - low + 1;
            int rightElements = high - mid + 1;

            if (nums[mid] == nums[mid + 1]) {
                if (rightElements % 2 == 1) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (leftElements % 2 == 1) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[low];
    }
}