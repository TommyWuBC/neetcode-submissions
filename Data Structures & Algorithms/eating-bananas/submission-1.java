class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];
        for (int num : piles) {
            right = Math.max(right, num);
        }
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int k = (left + right)/2;
            int count = 0;
            for (int bananas: piles) {
                count += Math.ceilDiv(bananas, k);
            }
            if (count <= h) {
                if (k < min) {
                    min = k;
                }
                right = k-1;
            } else {
                left = k+1;
            }
        }
        return min;
    }
}
