class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int pos = 3;
        int curr = 3;
        while (pos < n) {
            int temp = curr;
            a = b;
            b = temp;
            curr = a+b;
            pos++;
        }
        return curr;
    }
}
