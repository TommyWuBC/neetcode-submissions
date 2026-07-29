class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return 0;
        }
        int[] totalcost = new int[cost.length];
        Arrays.fill(totalcost, Integer.MAX_VALUE);
        totalcost[0] = cost[0];
        totalcost[1] = cost[1];
        for (int i = 0; i < cost.length-1; i++) {
            if (i+1 < cost.length && totalcost[i] + cost[i+1] < totalcost[i+1]) {
                totalcost[i+1] = totalcost[i] + cost[i+1];
            }
             if (i+2 < cost.length && totalcost[i] + cost[i+2] < totalcost[i+2]) {
                totalcost[i+2] = totalcost[i] + cost[i+2];
            }
        }
        return Math.min(totalcost[cost.length-1], totalcost[cost.length-2]);
    }
}
