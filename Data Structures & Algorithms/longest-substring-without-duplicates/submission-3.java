class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndexOfChar = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (lastIndexOfChar.containsKey(s.charAt(right))) {
                left = Math.max(left, lastIndexOfChar.get(s.charAt(right)) + 1);
            }
            lastIndexOfChar.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, (right - left) + 1);
        }
        return maxLen;
    }
}