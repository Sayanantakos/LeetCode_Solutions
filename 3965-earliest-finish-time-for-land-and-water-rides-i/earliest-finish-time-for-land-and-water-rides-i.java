class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        // Land first, then water
        for (int i = 0; i < landStartTime.length; i++) {
            int landEnd = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                int startWater = Math.max(landEnd, waterStartTime[j]);
                int finish = startWater + waterDuration[j];
                ans = Math.min(ans, finish);
            }
        }
        // Water first, then land
        for (int j = 0; j < waterStartTime.length; j++) {
            int waterEnd = waterStartTime[j] + waterDuration[j];
            for (int i = 0; i < landStartTime.length; i++) {
                int startLand = Math.max(waterEnd, landStartTime[i]);
                int finish = startLand + landDuration[i];
                ans = Math.min(ans, finish);
            }
        }
        return ans;
    }
}