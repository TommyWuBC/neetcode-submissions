class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right-left+1;
            if (len > resLen) {
                resLen = len;
                res = s.substring(left+1, right);
            }
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            len = right-left+1;
            if (len > resLen) {
                resLen = len;
                res = s.substring(left+1, right);
            }
        }
        return res;
    }
}
