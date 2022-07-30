//tony!
//https://codeforces.com/contest/1203/problem/D1

// created: 06-22-2022 Wed 01:16 PM

#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    string s, t; cin >> s >> t;
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i+1; j <= s.length(); j++) {
            string q = string(s);
            q.erase(q.begin()+i, q.begin()+j);
            int ptr = 0; bool works = true;
            for (int k = 0; k < t.length(); k++) {
                while (ptr < q.length() && q[ptr] != t[k]) ptr++;
                if (ptr == q.length()) works = false;
                ptr++;
            }
            if (works) ans = max(ans, j-i);
        }
    }
    cout << ans << "\n";
    return 0;
}