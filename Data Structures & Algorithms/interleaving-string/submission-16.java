class Solution {
    int[][] dp;
    String s1;
    String s2;
    String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        dp = new int[s1.length()+1][s2.length()+1];
        return backtrack(0, 0);
    }
    private boolean backtrack(int i, int j) {
        if (i >= s1.length() && j >= s2.length()) {
            return true;
        }
        int k = i+j;
        if (k >= s3.length()) {
            return true;
        }
        if (i >= s1.length()) {
            if (s3.charAt(k) == s2.charAt(j)) {
                return backtrack(i, j+1);
            }
            return false;
        }
        if (j >= s2.length()) {
            if (s3.charAt(k) == s1.charAt(i)) {
                return backtrack(i+1, j);
            }
            return false;
        }
        if (dp[i][j] != 0) {
            if (dp[i][j] == 1) {
                return true;
            }
            return false;
        }
        if (s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) {
            if (backtrack(i+1, j) || backtrack(i, j+1)) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = 2;
            }
        } else if (s3.charAt(k) == s1.charAt(i)) {
            if (backtrack(i+1, j)) {
                dp[i][j] = 1;
            } else {
                dp[i][j] =2;
            }
        } else if (s3.charAt(k) == s2.charAt(j)) {
            if (backtrack(i, j+1)) {
                dp[i][j] = 1;
            } else {
                dp[i][j] =2;
            }
        } else {
            return false;
        }
        if (dp[i][j] == 1) {
            return true;
        }
        return false;
    }
}