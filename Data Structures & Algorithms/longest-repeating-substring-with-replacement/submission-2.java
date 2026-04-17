class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> currentWindowsCharCount = new HashMap<>();
        int max = 0;
        //save quantities of characters
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            currentWindowsCharCount.put(
                s.charAt(right), 
                currentWindowsCharCount.getOrDefault(s.charAt(right), 0) + 1
            );
            while (!isWindowValid(currentWindowsCharCount, k)) {
                currentWindowsCharCount.put(
                    s.charAt(left), 
                    currentWindowsCharCount.get(s.charAt(left)) - 1 
                );
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public boolean isWindowValid(HashMap<Character, Integer> map, int k) {
        int windowSize = map.values().stream().mapToInt(i -> i).sum();
        int maxFreq = Collections.max(map.values());
        return (windowSize - maxFreq) <= k;
    }
}
