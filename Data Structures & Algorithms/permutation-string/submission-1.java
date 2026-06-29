class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int length = s1.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        Map<Character, Integer> comp = new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            comp.put(s2.charAt(i), comp.getOrDefault(s2.charAt(i), 0)+1);
        }
        while (left + length <= s2.length()) {
            int right = left + length -1;
            comp.put(s2.charAt(right), comp.getOrDefault(s2.charAt(right), 0)+1);
            if (map.equals(comp)) {
                return true;
            }
            if (comp.getOrDefault(s2.charAt(left), 1)-1 == 0) {
                comp.remove(s2.charAt(left));
            } else {
                comp.put(s2.charAt(left), comp.getOrDefault(s2.charAt(left), 1)-1);
            }
            left++;
        }
        return false;
    }
}
