class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);
        
        // Option 1: Remove from left only
        int option1 = right + 1;
        // Option 2: Remove from right only
        int option2 = n - left;
        // Option 3: Remove from both ends
        int option3 = (left + 1) + (n - right);
        
        return Math.min(option1, Math.min(option2, option3));
    }
}