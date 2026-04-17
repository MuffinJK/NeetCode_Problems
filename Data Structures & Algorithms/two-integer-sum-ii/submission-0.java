class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = 1;
        while (i < numbers.length - 1) {
            if (numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};

            if (numbers[i] + numbers[j] > target) {
                i++;
                j = i + 1;
            } else {
                j++;
                if (j >= numbers.length) {
                    i++;
                    j = i + 1;
                }
            }
        }
        return null;
    }
}
