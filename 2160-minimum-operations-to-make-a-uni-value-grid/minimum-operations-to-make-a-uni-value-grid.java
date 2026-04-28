class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        int idx = 0;
        
        // Flatten the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        
        // Check if all numbers have same remainder modulo x
        int rem = arr[0] % x;
        for (int num : arr) {
            if (num % x != rem) return -1;
        }
        
        // Sort to find median
        Arrays.sort(arr);
        int median = arr[size / 2];
        
        // Calculate operations
        int ops = 0;
        for (int num : arr) {
            ops += Math.abs(num - median) / x;
        }
        return ops;
    }
}