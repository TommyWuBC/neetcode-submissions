class Solution {
    int[][] memo;
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] col : memo) {
            Arrays.fill(col, -1);
        }
        this.text1 = text1;
        this.text2 = text2;
        return compare(0, 0);
    }
    private int compare(int sub1, int sub2) {
        if (sub1 == memo.length || sub2 == memo[0].length) {
            return 0;
        }
        if (memo[sub1][sub2] != -1) {
            return memo[sub1][sub2];
        }
        if (text1.charAt(sub1) == text2.charAt(sub2)) {
            memo[sub1][sub2] = 1 + compare(sub1+1, sub2+1);
            return memo[sub1][sub2];
        } else {
            memo[sub1][sub2] = Math.max(compare(sub1+1, sub2), compare(sub1, sub2+1));
            return memo[sub1][sub2];
        }
    }
}
