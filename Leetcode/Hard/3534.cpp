// https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/description/?envType=daily-question&envId=2026-07-10

class Solution {
public:
    vector<int> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<pair<int, int>> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = {nums[i], i};
        }
        sort(a.begin(), a.end());
        vector<int> pos(n);
        for (int i = 0; i < n; i++) {
            pos[a[i].second] = i;
        }
        int st[100005][18];
        int alpha = 0;
        for (int j = 0; j < n; j++) {
            while (a[j].first - a[alpha].first > maxDiff) {
                st[alpha][0] = j - 1;
                alpha++;
            }
        }
        while (alpha < n) {
            st[alpha][0] = n-1;
            alpha++;
        }

        // lift
        for (int j = 1; j < 18; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = st[ st[i][j-1] ][j-1];
            }
        }

        vector<int> ans(queries.size(), -1);
        for (int i = 0; i < queries.size(); i++) {
            int u = pos[queries[i][0]], v = pos[queries[i][1]];
            if (u > v) swap(u, v);
            if (u == v) {
                ans[i] = 0;
                continue;
            }
            int jumps = 0;
            for (int j = 17; j >= 0; j--) {
                if (st[u][j] < v) {
                    u = st[u][j];
                    jumps += (1 << j);
                }
            }
            if (st[u][0] >= v) ans[i] = jumps + 1;
        }

        return ans;
    }
};