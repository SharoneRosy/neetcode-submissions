class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap to hold the stones
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones to the max-heap
        for (int stone : stones) {
            pq.add(stone);
        }

        // Simulate smashing stones
        while (pq.size() > 1) {
            int x = pq.poll(); // Heaviest stone
            int y = pq.poll(); // Second heaviest stone
            if (x != y) {
                pq.add(x - y); // Add the remaining stone
            }
        }

        // If there's one stone left, return it; otherwise, return 0
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
