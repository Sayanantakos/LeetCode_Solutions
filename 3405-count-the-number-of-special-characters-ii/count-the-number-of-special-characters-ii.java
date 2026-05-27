class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        for (int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLower[c - 'a'] = i;
            } else {
                int idx = firstUpper[c - 'A'];
                if (idx > i) firstUpper[c - 'A'] = i;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != Integer.MAX_VALUE && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        return count;
    }
}