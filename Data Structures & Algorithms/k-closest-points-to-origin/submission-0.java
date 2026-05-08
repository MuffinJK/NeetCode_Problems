class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(Point::distanceToOrigin).reversed());
        for (int[] point : points) {
            queue.offer(new Point(point));

            if (queue.size() > k) queue.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().point();
        }
        return result;

    }
}

record Point(int[] point, double distanceToOrigin) {
    Point(int[] point) {
        this(point, Math.sqrt(point[0] * point[0] + point[1] * point[1]));
    }
}
