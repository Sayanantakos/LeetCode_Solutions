class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, wild = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') left++;
            else if (c == 'R') right++;
            else wild++;
        }
        // We can assign all wildcards to either direction
        // Max distance = max(|L - R| + wild, |R - L| + wild)
        return Math.abs(left - right) + wild;
    }
}