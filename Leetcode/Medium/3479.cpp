// https://leetcode.com/problems/fruits-into-baskets-iii/?envType=daily-question&envId=2025-08-06

class Solution {
public:
    int numOfUnplacedFruits(vector<int>& fruits, vector<int>& baskets) {
        int N = baskets.size();
        int M = (int) sqrt(N);
        vector<pair<int, int>> ranges;
        for (int i = 0; i < N; i += M) {
            ranges.emplace_back(i, min(i+M-1, N-1));
        }
        vector<int> blocks;
        for (auto p : ranges) {
            int cur = 0;
            for (int i = p.first; i <= p.second; i++) {
                cur = max(cur, baskets[i]);
            }
            blocks.push_back(cur);
        }
        int ans = 0;
        for (int f : fruits) {
            bool found = false;
            for (int i = 0; i < blocks.size() && !found; i++) {
                if (blocks[i] >= f) {
                    found = true;
                    for (int j = ranges[i].first; j <= ranges[i].second; j++) {
                        if (baskets[j] >= f) {
                            baskets[j] = 0;
                            break;
                        }
                    }
                    blocks[i] = 0;
                    for (int j = ranges[i].first; j <= ranges[i].second; j++) {
                        blocks[i] = max(blocks[i], baskets[j]);
                    }
                }
            }
            if (!found) ++ans;
        }
        return ans;
    }
};