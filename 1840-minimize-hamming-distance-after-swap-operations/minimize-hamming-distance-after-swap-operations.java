class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] swap : allowedSwaps) dsu.union(swap[0], swap[1]);
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new HashMap<>())
               .merge(source[i], 1, Integer::sum);
        }
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            Map<Integer, Integer> cnt = map.get(root);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                cnt.merge(target[i], -1, Integer::sum);
            } else {
                diff++;
            }
        }
        return diff;
    }
    
    class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}