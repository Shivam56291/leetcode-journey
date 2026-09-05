class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<n; i++){
            if(charFreqMap.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}