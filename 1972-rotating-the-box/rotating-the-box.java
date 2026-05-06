class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];
        
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
            // Fill remaining top cells with empty
            for (int k = bottom; k >= 0; k--) {
                res[k][m - 1 - i] = '.';
            }
        }
        // Fill any cells not set (should be already '.' by default)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == 0) res[i][j] = '.';
            }
        }
        return res;
    }
}