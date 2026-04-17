class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int foundZero = 0;
        for (int n : nums) {
            product *= n;
            if (n == 0) foundZero++;
        }

        if (foundZero > 1) return new int[nums.length];

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (foundZero == 1 && nums[i] != 0) {
                output[i] = 0;
                continue;
            } else if (foundZero == 1 && nums[i] == 0) {
                int productWithout0 = 1;
                for (int j = 0; j < nums.length; j++) {
                    productWithout0 *= i != j ? nums[j] : 1;
                }
                output[i] = productWithout0;
            } else {
                output[i] = product / nums[i];
            }
        }
        return output;
    }
}  
