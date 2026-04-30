class Solution {
public:
    int maxPathScore(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        // DP[i][j][c] = max score to reach (i,j) with exact cost c
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k + 1, -1)));
        
        // Starting cell (0,0) has value 0
        int startVal = grid[0][0];
        int startCost = (startVal == 1 || startVal == 2) ? 1 : 0;
        int startScore = (startVal == 1) ? 1 : (startVal == 2) ? 2 : 0;
        if (startCost <= k) dp[0][0][startCost] = startScore;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int val = grid[i][j];
                int costHere = (val == 1 || val == 2) ? 1 : 0;
                int scoreHere = (val == 1) ? 1 : (val == 2) ? 2 : 0;
                
                for (int prevCost = 0; prevCost <= k - costHere; prevCost++) {
                    int bestPrev = -1;
                    // from top
                    if (i > 0 && dp[i-1][j][prevCost] != -1)
                        bestPrev = max(bestPrev, dp[i-1][j][prevCost]);
                    // from left
                    if (j > 0 && dp[i][j-1][prevCost] != -1)
                        bestPrev = max(bestPrev, dp[i][j-1][prevCost]);
                    
                    if (bestPrev != -1) {
                        dp[i][j][prevCost + costHere] = max(
                            dp[i][j][prevCost + costHere], bestPrev + scoreHere
                        );
                    }
                }
            }
        }
        
        // Find max score at bottom-right with cost <= k
        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            if (dp[m-1][n-1][c] != -1)
                maxScore = max(maxScore, dp[m-1][n-1][c]);
        }
        return maxScore;
    }
};