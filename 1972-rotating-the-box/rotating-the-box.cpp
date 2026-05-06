class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& boxGrid) {
        int m = boxGrid.size(), n = boxGrid[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        
        // Process each row of boxGrid
        for (int i = 0; i < m; i++) {
            int bottom = n - 1; // position where next stone will fall
            // Scan from right to left in the row
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    // Place stone at bottom position
                    res[bottom][m - 1 - i] = '#';
                    bottom--;
                } else if (boxGrid[i][j] == '*') {
                    // Obstacle: place it, then reset bottom just above it
                    res[j][m - 1 - i] = '*';
                    bottom = j - 1;
                }
            }
            // Remaining cells above bottom are already '.' due to initialization
        }
        return res;
    }
};