class Solution {
    private int m, n;
    private char[][] grid;
    private boolean[][] visited;
    private int[] dirX = {0, 1, 0, -1};
    private int[] dirY = {1, 0, -1, 0};
    
    public boolean containsCycle(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        
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
    
    private boolean dfs(int x, int y, int px, int py, char target) {
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
}