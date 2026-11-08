// warith + edward

#include <bits/stdc++.h>

using namespace std;

bool query(int x, int y) {
    cout << x << ' ' << y << endl;
    char res; cin >> res;
    return res == 'T';
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);
    srand(time(NULL));

    int T; cin >> T;
    while (T--) {
        int n; cin >> n;
        vector<int> t, f;

        bool v1, v2;
        bool n1 = rand() % 2, n2 = rand() % 2;
        int s1 = (-2 * n1 + 1), s2 = (-2 * n2 + 1);

        // let's start by finding the values of 1 and 2
        if (!query(s1 * 1, s2 * 2)) {
            v1 = false ^ n1;
            v2 = false ^ n2;
        } else if (!query(1 * s1, -2 * s2)) {
            // f.push_back(1);
            // t.push_back(2);
            v1 = false ^ n1;
            v2 = true ^ n2;
        } else if (!query(-1 * s1, 2 * s2)) {
            // t.push_back(1);
            // f.push_back(2);
            v1 = true ^ n1;
            v2 = false ^ n2;
        } else {
            // t.push_back(1);
            // t.push_back(2);
            v1 = true ^ n1;
            v2 = true ^ n2;
        }

        if (v1) t.push_back(1);
        else f.push_back(1);
        if (v2) t.push_back(2);
        else f.push_back(2);

        int fuck = (f.size() == 0 ? -t[0] : f[0]); // guaranteed false
        // now do other things
        for (int i = 3; i <= n; i++) {
            if (query(i, fuck)) t.push_back(i);
            else f.push_back(i);
        }
        vector<char> ans(n, 'F');
        for (int x : t) ans[x-1] = 'T';
        for (char c : ans) cout << c;
        cout << endl;
    }
    return 0;
}