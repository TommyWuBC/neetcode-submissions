class Solution {

    public String encode(List<String> strs) {
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            StringBuilder sb = new StringBuilder();
            String length = Integer.toString(s.length());
            sb.append(length+"#");
            sb.append(s);
            list.add(sb.toString());
        }
        return list.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        for (int i = 0;  i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                int length = 0;
                while (str.charAt(j) != '#') {
                    length = length*10 + Integer.parseInt(String.valueOf(str.charAt(j)));
                    j++;
                }
                j++;
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < j+length; k++) {
                    sb.append(str.charAt(k));
                }
                String word = sb.toString();
                output.add(word);
                i = j+length;
            }
        }
        return output;
    }
}
