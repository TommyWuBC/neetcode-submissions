class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> mapt = new HashMap<>();
        for (char tchar : t.toCharArray()) {
            mapt.put(tchar, mapt.getOrDefault(tchar, 0)+1);
        }
        int have = 0;
        int need = mapt.size();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>();
        String result = "";
        while (right < s.length()){
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
            if (freqMap.get(c) == mapt.getOrDefault(c, 0)) {
                have++;
            }
            while (have == need) {
                if (right - left +1 < min) {
                    min = right - left +1;
                    result = s.substring(left, right+1);
                }
                if (mapt.containsKey(s.charAt(left)) && freqMap.get(s.charAt(left)) == mapt.get(s.charAt(left))) {
                    have--;
                }
                int count = freqMap.getOrDefault(s.charAt(left), 1);
                if (count <= 1) {
                    freqMap.remove(s.charAt(left));
                } else {
                    freqMap.put(s.charAt(left), count -1);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
