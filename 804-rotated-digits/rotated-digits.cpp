class Solution {
public:
    int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }
    
private:
    bool isGood(int x) {
        bool hasRotatingDigit = false;
        while (x > 0) {
            int digit = x % 10;
            // If any digit is 3, 4, or 7, number becomes invalid after rotation
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            // If we see any digit that changes when rotated (2,5,6,9), mark it
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasRotatingDigit = true;
            }
            x /= 10;
        }
        // Good only if at least one digit changes AND no invalid digits
        return hasRotatingDigit;
    }
};