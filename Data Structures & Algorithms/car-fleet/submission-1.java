class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < position.length) {
            if (stack.size() == 0) {
                stack.push(position[i]);
                i++;
                continue;
            }

            double carBehindTime = (double)(target - stack.peek()) / map.get(stack.peek());
            double carInFront = (double)(target - position[i]) / map.get(position[i]);

            // fleet
            if (carBehindTime <= carInFront) {
                stack.pop();
            } else {
                stack.push(position[i]);
                i++;
            }
        }
        return stack.size();
    }
}
