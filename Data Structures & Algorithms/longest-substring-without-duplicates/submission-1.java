class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seenChars = new HashSet<>();
        int currentMaxSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!seenChars.add(s.charAt(j))) {
                    currentMaxSubstring = Math.max(currentMaxSubstring, seenChars.size());
                    seenChars.clear();
                    break;
                }
            }
            //if the substring is valid to the end
            currentMaxSubstring = Math.max(currentMaxSubstring, seenChars.size());
        }
        return currentMaxSubstring;
    }
}
