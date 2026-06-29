class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums,output, 0, new ArrayList<>());
        return output;
    }
    private void backtrack(int[] nums, List<List<Integer>> output, int index, List<Integer> curr) {
        if (index == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(nums, output, index+1, curr);
        curr.remove(curr.size()-1);
        backtrack(nums, output, index+1, curr);
    }
}
