class Solution {
    String s;
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        this.s = s;
        output = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        return output;
    }
    private void backtrack(int start, List<String> list) {
        if (start >= s.length()) {
            output.add(new ArrayList<>(list));
            return;
        }
        for (int i = start+1; i < s.length()+1; i++) {
            if (isPalindrome(s.substring(start, i))) {
                list.add(s.substring(start, i));
                backtrack(i, list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length()-1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
