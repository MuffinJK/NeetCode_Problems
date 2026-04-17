class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for (int n : nums) {
            if (n == 0) zeroCount++;
            else product *= n;
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                output[i] = 0;
            } else if (zeroCount == 1) {
                output[i] = nums[i] == 0 ? product : 0;
            } else {
                output[i] = product / nums[i];
            }
        }
        return output;
    }
}