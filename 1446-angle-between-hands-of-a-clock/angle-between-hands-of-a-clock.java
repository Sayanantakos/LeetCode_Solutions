class Solution {
    public double angleClock(int hour, int minutes) {
        // Calculate the angle of the minute hand (360 degrees per 60 minutes)
        double minuteAngle = minutes * 6.0; 
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        
        // Calculate the absolute difference
        double diff = Math.abs(hourAngle - minuteAngle);
        
        // Return the smaller angle (min of diff and 360 - diff)
        return Math.min(diff, 360.0 - diff);
    }
}