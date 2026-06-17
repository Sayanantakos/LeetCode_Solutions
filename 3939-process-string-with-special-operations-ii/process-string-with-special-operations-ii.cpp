#include <string>
#include <vector>
#include <algorithm>

class Solution {
public:
    char processStr(std::string s, long long k) {
        int n = s.length();
        // Use vector to store lengths, initialized to 0
        std::vector<long long> lengths(n + 1, 0);
        
        // Forward pass: calculate the length of the string after each operation
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c >= 'a' && c <= 'z') {
                lengths[i + 1] = lengths[i] + 1;
            } else if (c == '*') {
                lengths[i + 1] = std::max(0LL, lengths[i] - 1);
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
        
        // Backward pass: map the index k back to the original operation
        long long currK = k;
        for (int i = n - 1; i >= 0; i--) {
            char c = s[i];
            long long prevLen = lengths[i];
            
            if (c >= 'a' && c <= 'z') {
                // If currK is exactly at the end, this was the character added
                if (currK == prevLen) {
                    return c;
                }
            } else if (c == '*') {
                // '*' removed the last character, currK remains the same
                // because it corresponds to the same position in the previous step
                continue; 
            } else if (c == '#') {
                // '#' duplicated the string: prev + prev.
                // If currK is in the second half, map it to the corresponding index in the first half
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
};