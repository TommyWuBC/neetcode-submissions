class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('|| c== '['|| c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char popped  = stack.pop();
                if (popped == '(' && c == ')'|| popped == '[' && c == ']' || popped == '{' && c == '}') {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
