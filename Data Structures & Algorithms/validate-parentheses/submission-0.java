class Solution {
    public boolean isValid(String s) {
        Stack<Character> nextClosingBracket = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (isClosingBracket(s.charAt(i))) {
                if (nextClosingBracket.isEmpty() || nextClosingBracket.pop() != s.charAt(i)) {
                    return false;
                }
            } else {
                nextClosingBracket.push(s.charAt(i) == '(' ? ')' : s.charAt(i) == '[' ? ']' : '}');
            }
        }
        return nextClosingBracket.size() == 0;
    }

    public boolean isClosingBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }
}
