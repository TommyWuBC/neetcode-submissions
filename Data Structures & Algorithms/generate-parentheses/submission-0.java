class Solution {
    int n;
    List<String> output;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        output = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0);
        return output;
    }
    private void backtrack(StringBuilder curr, int opened, int closed) {
        if (opened == n && closed == n) {
            output.add(curr.toString());
            return;
        }
        if (closed < opened) {
            curr.append(')');
            backtrack(curr, opened, closed+1);
            curr.deleteCharAt(curr.length()-1);
        }
        if (opened < n) {
            curr.append('(');
            backtrack(curr, opened+1, closed);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
