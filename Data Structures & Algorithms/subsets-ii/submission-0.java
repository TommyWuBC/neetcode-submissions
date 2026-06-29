class Solution {
    int[] nums;
    List<List<Integer>> output;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        output = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        return output;
    }
    private void backtrack(int index, List<Integer> curr) {
        if (index >= nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index+1, curr);
        curr.remove(curr.size()-1);
        while(index+1 < nums.length && nums[index+1] == nums[index]) {
            index++;
        }
        backtrack(index+1, curr);
    }
}
