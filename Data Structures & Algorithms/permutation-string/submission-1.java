class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length();

        while (right <= s2.length()) {
            if (isAnagram(s1, s2.substring(left, right))) return true;
            right++;
            left++;
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Long> countS = s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        Map<Character, Long> countT = t.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        return countS.equals(countT);
    }
}
