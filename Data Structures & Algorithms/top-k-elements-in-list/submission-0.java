class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length +1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length-1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    result[index] = j;
                    index++;
                }
            }
        }
        return result;
    }
}
