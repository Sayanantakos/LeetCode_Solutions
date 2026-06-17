public class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        
        // Forward pass: calculate the length of the string after each operation.
        // The length can be up to 10^15, which fits in a long.
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lengths[i + 1] = lengths[i] + 1;
            } else if (c == '*') {
                lengths[i + 1] = Math.max(0, lengths[i] - 1);
            } else if (c == '#') {
                lengths[i + 1] = lengths[i] * 2;
            } else if (c == '%') {
                lengths[i + 1] = lengths[i];
            }
        }
        
        // If the requested index is out of bounds, return '.'
        if (k < 0 || k >= lengths[n]) {
            return '.';
        }
        
        // Backward pass: map the index k back to the original operation.
        long currK = k;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = lengths[i];
            
            if (c >= 'a' && c <= 'z') {
                // If currK is at the end, this was the character added
                if (currK == prevLen) {
                    return c;
                }
            } else if (c == '*') {
                // '*' removed the last character, currK remains the same
                currK = currK;
            } else if (c == '#') {
                // '#' duplicated the string: prev + prev.
                // If currK is in the second half, map it to the first half.
                if (currK >= prevLen) {
                    currK -= prevLen;
                }
            } else if (c == '%') {
                // '%' reversed the string: index becomes (L - 1 - index)
                currK = prevLen - 1 - currK;
            }
        }
        
        return '.';
    }
}