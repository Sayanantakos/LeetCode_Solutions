class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                // Update max distance if valid
                maxDist = Math.max(maxDist, j - i);
                // Look for a further j
                j++;
            } else {
                // Move i forward to decrease nums1[i]
                i++;
            }
        }

        return maxDist;
    }
}