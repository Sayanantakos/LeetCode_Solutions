class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minVal = Integer.MAX_VALUE;
        for (int num : nums1) {
            minVal = Math.min(minVal, num);
        }
        
        // Check if we can make all even
        boolean canEven = true;
        for (int num : nums1) {
            if (num % 2 != 0 && (num - minVal) % 2 != 0) {
                canEven = false;
                break;
            }
        }
        if (canEven) return true;
        
        // Check if we can make all odd
        boolean canOdd = true;
        for (int num : nums1) {
            if (num % 2 == 0) {
                if (num - minVal >= 1 && (num - minVal) % 2 != 0) {
                    // Can make odd by subtracting minVal
                } else {
                    canOdd = false;
                    break;
                }
            }
        }
        
        return canOdd;
    }
}