

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]}); // {destination, weight}
        }

        // Step 2: Initialize the priority queue and distance array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, time}
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Add the source node to the queue
        pq.add(new int[]{k, 0});

        // Step 3: Process the graph using Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            // Skip if we have already found a shorter path
            if (time > dist[node]) continue;

            // Update the distances for neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (time + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = time + edgeWeight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // Step 4: Find the maximum time to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Some nodes are unreachable
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
