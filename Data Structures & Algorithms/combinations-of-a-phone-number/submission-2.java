class Solution {
    List<String> output;
    String digits;
    List<Cursor> clist;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        this.digits = digits;
        clist = new ArrayList<>();
        output = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            int i = (int) (c - '0');
            switch(i) {
                case 2:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("a", "b", "c"))));
                    break;
                case 3:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("d", "e", "f"))));
                    break;
                case 4:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("g", "h", "i"))));
                    break;
                case 5:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("j", "k", "l"))));
                    break;
                case 6:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("m", "n", "o"))));
                    break;
                case 7:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("p", "q", "r", "s"))));
                    break;
                case 8:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("t", "u", "v"))));
                    break;
                default:
                    clist.add(new Cursor(0, new ArrayList<>(List.of("w", "x", "y", "z"))));
                    break;
            }
        }
        backtrack(new StringBuilder(), 0, 0);
        return output;
    }
    private void backtrack(StringBuilder sb, int index, int cindex) {
        if (sb.length() == digits.length() || index >= digits.length()) {
            output.add(sb.toString());
            return;
        }
        char a = digits.charAt(index);
        int digit = (int) (a - '0');
        if (cindex >= clist.size()) {
            return;
        }
        Cursor c = clist.get(cindex);
        if (c.pos >= c.list.size()) {
            return;
        }
        int temp = c.pos;
        for (int i = c.pos; i < c.list.size(); i++) {
            sb.append(c.list.get(c.pos));
            c.pos++;
            backtrack(sb, index+1, cindex+1);
            sb.deleteCharAt(sb.length()-1);
        }
        c.pos = temp;
    }
    private class Cursor {
        int pos;
        List<String> list;
        public Cursor(int pos, List<String> list) {
            this.pos = pos;
            this.list = list;
        }
    }
}
