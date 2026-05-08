class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stonesHeap = new PriorityQueue(Collections.reverseOrder());
        for (int stone : stones) {
            stonesHeap.offer(stone);
        }

        while (stonesHeap.size() > 1) {
            int x = stonesHeap.poll();
            int y = stonesHeap.poll();

            int newStone = Math.abs(x - y);
            stonesHeap.offer(newStone);
        }
        return stonesHeap.poll();
    }
}
