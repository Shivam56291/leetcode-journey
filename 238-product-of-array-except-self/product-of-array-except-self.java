class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int mul = 1;

        // Prefix part
        for (int i = 0; i < n; i++) {
            ans[i] = mul;
            mul *= nums[i];

        }

        mul = 1;

        // Suffix part
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * mul;
            mul = mul * nums[i];
        }

        return ans;
    }
}