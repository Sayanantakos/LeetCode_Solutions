class Solution {
public:
    bool uniformArray(vector<int>& nums1) {
        int n = nums1.size();
        int minVal = *min_element(nums1.begin(), nums1.end());
        
        // Check if we can make all even
        bool canEven = true;
        for (int num : nums1) {
            if (num % 2 != 0 && (num - minVal) % 2 != 0) {
                canEven = false;
                break;
            }
        }
        if (canEven) return true;
        
        // Check if we can make all odd
        bool canOdd = true;
        for (int num : nums1) {
            if (num % 2 == 0) {
                if ((num - minVal) % 2 != 0 && num - minVal >= 1) {
                    // Can make odd by subtracting minVal
                } else {
                    canOdd = false;
                    break;
                }
            }
        }
        
        return canOdd;
    }
};