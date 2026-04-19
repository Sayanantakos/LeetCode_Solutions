#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int i = 0, j = 0;
        int maxDist = 0;
        int n1 = nums1.size();
        int n2 = nums2.size();

        while (i < n1 && j < n2) {
            // Check if the current pair is valid
            if (nums1[i] <= nums2[j]) {
                maxDist = max(maxDist, j - i);
                // Try to increase distance by moving j
                j++;
            } else {
                // Current nums1[i] is too large, move to a smaller value
                i++;
            }
        }
        
        return maxDist;
    }
};