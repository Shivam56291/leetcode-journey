class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int longestLength = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longestLength = Math.max(longestLength, length);
            }
        }

        return longestLength;
    }
}