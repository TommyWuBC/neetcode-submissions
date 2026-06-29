class Solution {
    int[] nums;
    List<List<Integer>> output;
    Set<Integer> used;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        output = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        used = new HashSet<>();
        backtrack(new ArrayList<>());
        return output;
    }
    private void backtrack(List<Integer> curr) {
        if (used.size() == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) {
            if (!used.contains(num)) {
                curr.add(num);
                used.add(num);
                backtrack(curr);
                curr.remove(curr.size()-1);
                used.remove(num);
            }
        }
    }
}
