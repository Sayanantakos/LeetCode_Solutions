class Solution {
public:
    int earliestFinishTime(vector<int>& landStartTime, vector<int>& landDuration, 
                           vector<int>& waterStartTime, vector<int>& waterDuration) {
        int ans = INT_MAX;
        // Land first, then water
        for (int i = 0; i < landStartTime.size(); i++) {
            int landEnd = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.size(); j++) {
                int startWater = max(landEnd, waterStartTime[j]);
                int finish = startWater + waterDuration[j];
                ans = min(ans, finish);
            }
        }
        // Water first, then land
        for (int j = 0; j < waterStartTime.size(); j++) {
            int waterEnd = waterStartTime[j] + waterDuration[j];
            for (int i = 0; i < landStartTime.size(); i++) {
                int startLand = max(waterEnd, landStartTime[i]);
                int finish = startLand + landDuration[i];
                ans = min(ans, finish);
            }
        }
        return ans;
    }
};