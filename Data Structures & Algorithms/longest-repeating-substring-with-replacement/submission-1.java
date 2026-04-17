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

    public boolean isWindowValid(HashMap<Character, Integer> currentWindowsCharCount, int k) {
        for (char key : currentWindowsCharCount.keySet()) {
            int usedK = 0;
            for (char otherKey : currentWindowsCharCount.keySet()) {
                if (otherKey == key) continue;
                usedK += currentWindowsCharCount.get(otherKey);
            }
            if (usedK <= k) return true;
        }
        return false;
    }
}
