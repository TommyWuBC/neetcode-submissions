class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        output = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return output;
    }
    private void backtrack(int[] nums, int target, int index, int sum,  List<Integer> curr) {
        if (sum == target) {
            output.add(new ArrayList<>(curr));
            return;
        } else if (sum > target) {
            
            return;
        }
        if (index >= nums.length) {
            
            return;
        }
        curr.add(nums[index]);
        backtrack(nums, target, index, sum + nums[index], curr);
        curr.remove(curr.size()-1);
        backtrack(nums, target, index+1, sum, curr);
        
    }
}
