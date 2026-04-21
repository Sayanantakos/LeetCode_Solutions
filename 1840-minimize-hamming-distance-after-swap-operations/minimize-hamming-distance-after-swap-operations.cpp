class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        int n = source.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        auto unite = [&](int x, int y) {
            parent[find(x)] = find(y);
        };
        for (auto& s : allowedSwaps) unite(s[0], s[1]);
        unordered_map<int, unordered_map<int, int>> mp;
        for (int i = 0; i < n; i++) mp[find(i)][source[i]]++;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if (mp[root][target[i]] > 0) mp[root][target[i]]--;
            else diff++;
        }
        return diff;
    }
};