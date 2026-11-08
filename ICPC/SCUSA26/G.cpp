// edward

#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    string s; cin >> s;
    int n = s.size();
    set<char> l;
    for (char c : s)
        l.insert(c);

    vector<char> ch;
    for (char x : l) {
        set<int> f;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == x && s[i + 1] != s[i])
                f.insert(s[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            if (s[i] == x && s[i - 1] != s[i])
                f.insert(s[i - 1]);
        }
        if (f.size() <= 1)
            ch.push_back(x);
    }

    sort(ch.begin(), ch.end());
    string res = "";
    for (char c : ch)
        res += c;
    cout << res;

    return 0;
}