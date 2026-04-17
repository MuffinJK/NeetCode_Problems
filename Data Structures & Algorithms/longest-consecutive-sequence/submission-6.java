class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        HashSet<Integer> seen = new HashSet<>();
        seen.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            seen.add(nums[i]);
        }

        int maxConsecutive = 0;
        int currentConsecutive = 0;
        int foundNumbers = 0;
        while (foundNumbers < seen.size()) {
            if (seen.contains(min)) {
                foundNumbers++;
                currentConsecutive++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                currentConsecutive = 0;
            }
            min++;
        }
        maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        return maxConsecutive;
    }
}
