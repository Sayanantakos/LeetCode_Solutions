class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }
    
    private boolean isGood(int x) {
        boolean hasRotatingDigit = false;
        while (x > 0) {
            int digit = x % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasRotatingDigit = true;
            }
            x /= 10;
        }
        return hasRotatingDigit;
    }
}