class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n + 1); // Initialize Disjoint Set with size n+1
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // If both nodes are already connected, the edge is redundant
            if (ds.find(u) == ds.find(v)) {
                return edge;
            } else {
                ds.union(u, v); // Union the nodes
            }
        }
        return new int[0]; // Should not reach here
    }
}

class DisjointSet {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize the Disjoint Set
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Each node is its own parent initially
            rank[i] = 0;   // Rank is initialized to 0
        }
    }

    // Find the ultimate parent of a node with path compression
    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    // Union two nodes by rank
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU; // Attach rootV under rootU
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV; // Attach rootU under rootV
            } else {
                parent[rootV] = rootU; // If ranks are equal, attach one under the other and increase rank
                rank[rootU]++;
            }
        }
    }
}
