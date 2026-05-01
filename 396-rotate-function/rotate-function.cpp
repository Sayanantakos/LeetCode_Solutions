class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        long long n = nums.size();
        long long sum = 0, f = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            f += (long long) i * nums[i];
        }
        
        long long maxVal = f;
        for (int k = 1; k < n; k++){
            f = f + sum - (long long) n * nums[n - k];
            maxVal = max(maxVal, f);
        }
        
        return (int) maxVal;
    }
};