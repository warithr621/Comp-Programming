// https://leetcode.com/problems/best-sightseeing-pair/description/?envType=daily-question&envId=2024-12-27

#define max(X, Y) (((X) > (Y)) ? (X) : (Y))

int maxScoreSightseeingPair(int* values, int valuesSize) {
    int maxPrev = values[0];
    int ans = 0;
    for (int i = 1; i < valuesSize; i++) {
        ans = max(ans, maxPrev + values[i] - i);
        maxPrev = max(maxPrev, values[i] + i);
    }
    return ans;
}