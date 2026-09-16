class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (m < n) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        // Initial window
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if (isMatched(map1, map2)) {
            return true;
        }

        // Sliding window
        for (int i = n; i < m; i++) {

            // Remove left character
            map2[s2.charAt(i - n) - 'a']--;

            // Add right character
            map2[s2.charAt(i) - 'a']++;

            if (isMatched(map1, map2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isMatched(int[] map1, int[] map2) {

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }

        return true;
    }
}