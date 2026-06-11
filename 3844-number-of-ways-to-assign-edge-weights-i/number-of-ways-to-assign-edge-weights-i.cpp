class Solution {
private:
    const int MOD = 1e9 + 7;
    
    void dfs(int node, int parent, vector<int>& depth, vector<vector<int>>& graph) {
        for (int child : graph[node]) {
            if (child != parent) {
                depth[child] = depth[node] + 1;
                dfs(child, node, depth, graph);
            }
        }
    }
    
public:
    int assignEdgeWeights(vector<vector<int>>& edges) {
        int n = edges.size() + 1;
        vector<vector<int>> graph(n + 1);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        
        vector<int> depth(n + 1, 0);
        dfs(1, 0, depth, graph);
        
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) maxDepth = max(maxDepth, depth[i]);
        
        if (maxDepth == 0) return 0;
        
        long long ways = 1;
        for (int i = 0; i < maxDepth - 1; i++) ways = (ways * 2) % MOD;
        
        return ways;
    }
};