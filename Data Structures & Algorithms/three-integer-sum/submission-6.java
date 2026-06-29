class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new  ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        for (int i = 0; i < nums.length -1; i++) {
            int k = nums.length-1;
            int j = i+1;
            while (j < k) {
                int add = nums[j] + nums[k];
                if (nums[i] + add == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++;
                    k--;
                    if (!seen.contains(list)) {
                        output.add(list);
                        seen.add(list);
                    }
                } else if (nums[i] + add < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }
}
