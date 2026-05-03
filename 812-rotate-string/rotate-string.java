class Solution {
    public boolean rotateString(String s, String goal) {
        //if lengths differ, s cannot become goal by rotation
        if (s.length() != goal.length()) return false;
        //if s concatenated with itself contains goal, then goal is a rotation of s
        return (s + s).contains(goal);
    }
}