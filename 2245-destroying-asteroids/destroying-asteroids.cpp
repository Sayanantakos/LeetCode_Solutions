class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        sort(asteroids.begin(), asteroids.end());
        long long curr = mass;
        for (int a : asteroids) {
            if (curr >= a) {
                curr += a;
            } else {
                return false;
            }
        }
        return true;
    }
};