class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] depth = new int[n + 1];
        dfs(1, 0, depth, graph);
        
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) maxDepth = Math.max(maxDepth, depth[i]);
        
        // For path of length L = maxDepth, need odd number of weight-1 edges
        // Number of ways = 2^(L-1) (half of all 2^L assignments)
        if (maxDepth == 0) return 0;
        
        long ways = 1;
        for (int i = 0; i < maxDepth - 1; i++) ways = (ways * 2) % MOD;
        
        return (int) ways;
    }
    
    private void dfs(int node, int parent, int[] depth, List<Integer>[] graph) {
        for (int child : graph[node]) {
            if (child != parent) {
                depth[child] = depth[node] + 1;
                dfs(child, node, depth, graph);
            }
        }
    }
}