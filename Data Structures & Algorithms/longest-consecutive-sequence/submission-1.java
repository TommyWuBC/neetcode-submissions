class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (map.containsKey(i-1)) {
                int count = map.get(i-1) +1;
                if (count > max) {
                    max = count;
                }
                map.put(i, count);
            } else {
                map.put(i, 1);
                if (max < 1) {
                    max = 1;
                }
            }
        }
        return max;
    }
}
