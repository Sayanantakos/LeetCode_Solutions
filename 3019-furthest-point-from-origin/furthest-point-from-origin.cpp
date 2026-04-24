class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int left = 0, right = 0, wild = 0;
        for (char c : moves) {
            if (c == 'L') left++;
            else if (c == 'R') right++;
            else wild++;
        }
        // All wildcards can be used to extend the dominant direction
        return abs(left - right) + wild;
    }
};