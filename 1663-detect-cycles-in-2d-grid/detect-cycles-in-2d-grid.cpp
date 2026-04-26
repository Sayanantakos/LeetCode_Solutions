class Solution {
private:
    int m, n;
    vector<vector<char>> grid;
    vector<vector<bool>> visited;
    int dirX[4] = {0, 1, 0, -1};
    int dirY[4] = {1, 0, -1, 0};
    
    bool dfs(int x, int y, int px, int py, char target) {
        visited[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dirX[d];
            int ny = y + dirY[d];
            
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (grid[nx][ny] != target) continue;
            if (nx == px && ny == py) continue;  // can't go back to previous cell
            
            if (visited[nx][ny]) return true;  // found a cycle
            
            if (dfs(nx, ny, x, y, target)) return true;
        }
        return false;
    }
    
public:
    bool containsCycle(vector<vector<char>>& grid) {
        this->grid = grid;
        this->m = grid.size();
        this->n = grid[0].size();
        this->visited.assign(m, vector<bool>(n, false));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }
};