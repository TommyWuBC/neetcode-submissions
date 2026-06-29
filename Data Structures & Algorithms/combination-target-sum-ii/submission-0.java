class Solution {
    List<List<Integer>> output;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        output = new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;

        backtrack(0, new ArrayList<>(), 0);
        return output;
    }
    private void backtrack(int index, List<Integer> curr, int sum) {
        if (sum == target) {
            output.add(new ArrayList<>(curr));
            return;
        }
        if (index >= candidates.length || sum > target) {
            return;
        }
        
        curr.add(candidates[index]);
        backtrack(index+1, curr, sum+candidates[index]);
        curr.remove(curr.size()-1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        backtrack(index+1, curr, sum);
    }
}
