class Solution {
private:
    vector<vector<vector<int>>> dirs = {
        {{0, -1}, {0, 1}},   // 1: left, right
        {{-1, 0}, {1, 0}},   // 2: up, down
        {{0, -1}, {1, 0}},   // 3: left, down
        {{0, 1}, {1, 0}},    // 4: right, down
        {{0, -1}, {-1, 0}},  // 5: left, up
        {{0, 1}, {-1, 0}}    // 6: right, up
    };
    
    bool dfs(vector<vector<int>>& grid, int x, int y, int m, int n, vector<vector<bool>>& visited) {
        if (x == m - 1 && y == n - 1) return true;
        visited[x][y] = true;
        
        int type = grid[x][y];
        for (auto& dir : dirs[type - 1]) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
            
            int nextType = grid[nx][ny];
            for (auto& backDir : dirs[nextType - 1]) {
                if (nx + backDir[0] == x && ny + backDir[1] == y) {
                    if (dfs(grid, nx, ny, m, n, visited)) return true;
                    break;
                }
            }
        }
        return false;
    }
    
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        return dfs(grid, 0, 0, m, n, visited);
    }
};