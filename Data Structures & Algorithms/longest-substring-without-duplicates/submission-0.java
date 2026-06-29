class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                for (int j = i-count; j < index; j++) {
                    map.remove(s.charAt(j));
                }
                count = i-index;
                map.put(c, i);
            } else {
                map.put(c, i);
                count++;
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
}
