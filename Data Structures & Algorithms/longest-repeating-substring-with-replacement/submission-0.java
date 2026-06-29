class Solution {
    public int characterReplacement(String s, int k) {
        int windowLength = 0;
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (int right =0; right < s.length(); right++){
            windowLength = right-left+1;
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(right)));
            if (windowLength <= maxFrequency + k) {
                max = Math.max(max, right-left+1);
            } else {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 1)-1);
                left++;
            }
        }
        return max;
    }
}
