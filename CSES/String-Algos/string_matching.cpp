//CSES String Matching
#include <bits/stdc++.h>
using namespace std;

vector<int> pfx(string s) {
    int n = s.length();
    vector<int> ret(n);
    for (int i = 1; i < n; i++) {
        int j = ret[i-1];
        while(j > 0 && s[i] != s[j]) j = ret[j-1];
        if (s[i] == s[j]) ++j;
        ret[i] = j;
    }
    return ret;
}

int main() {
    string t,s; cin >> t >> s;
    t = s + "#" + t;
    vector<int> v = pfx(t);
    int ans = 0;
    for (int i = 0; i < v.size(); i++) {
        if (v[i] == s.size()) ++ans;
    }
    cout << ans << '\n';
}