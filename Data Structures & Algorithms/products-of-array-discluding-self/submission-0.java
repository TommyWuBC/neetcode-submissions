class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int total = 1;
        for (int i : nums) {
            if (i != 0) {
                total *= i;
            } else {
                zeroCount++;
            }
        }
        int[] output = new int[nums.length];
        int index = 0;
        for (int j : nums) {
            if (zeroCount > 1) {
                output[index++] = 0;
            } else if (j == 0)  {
                output[index++] = total;
            } else if (zeroCount == 1 && j != 0) {
                output[index++] = 0;
            } else {
                output[index++] = total/j;
            }
        }
        return output;
    }
}  
