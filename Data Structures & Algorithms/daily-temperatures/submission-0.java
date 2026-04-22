class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < temperatures.length) {
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            } else {
                stack.push(i);
                i++;
            }
        }
        return result;
    }
}
