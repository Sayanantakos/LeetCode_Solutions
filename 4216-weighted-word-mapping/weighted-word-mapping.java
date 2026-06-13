class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }
            int mod = sum % 26;
            char mapped = (char) ('z' - mod);
            sb.append(mapped);
        }
        return sb.toString();
    }
}