class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int n : counts.keySet()) {
            int freq = counts.get(n);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(n);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int j = bucket.length - 1; j > 0 && idx < k; j--) {
            if (bucket[j] != null) {
                for (int num : bucket[j]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }
}