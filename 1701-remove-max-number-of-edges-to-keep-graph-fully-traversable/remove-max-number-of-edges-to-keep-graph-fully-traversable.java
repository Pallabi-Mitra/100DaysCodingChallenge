class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        // Union-Find data structures for Alice and Bob
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int removedEdges = 0;
        int aliceEdges = 0;
        int bobEdges = 0;

        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceUnion = alice.union(edge[1], edge[2]);
                boolean bobUnion = bob.union(edge[1], edge[2]);
                if (aliceUnion) aliceEdges++;
                if (bobUnion) bobEdges++;
                if (!aliceUnion && !bobUnion) removedEdges++;
            }
        }

        // Process type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.union(edge[1], edge[2])) {
                    aliceEdges++;
                } else {
                    removedEdges++;
                }
            }
        }

        // Process type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bob.union(edge[1], edge[2])) {
                    bobEdges++;
                } else {
                    removedEdges++;
                }
            }
        }

        // Check if Alice and Bob can traverse their graphs fully
        if (aliceEdges == n - 1 && bobEdges == n - 1) {
            return removedEdges;
        } else {
            return -1;
        }
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;

            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
}