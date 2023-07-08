// https://codeforces.com/contest/1846/problem/F
// 晴れ 晴れ

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define floosh << endl
// lol floosh

void solve() {
    int n; cin >> n;
    map<int, int> freq;
    vector<int> a(n);
    for (int &i : a) {
        cin >> i;
        ++freq[i];
    }
    vector<int> rem;
    int ans = -1;
    
    for (int _ = 0; _ < 5; ++_) {
        if (a.size() - rem.size() == 1) {
            // there's one element that shouldn't be being removed, so now we must find the answer
            cout << "! " << ans floosh;
            break;
        }
        
        // give query to the system
        cout << "- " << rem.size();
        for (int x : rem) cout << ' ' << x;
        cout floosh;
        
        // take in the new input
        vector<int> new_a(a.size() - rem.size());
        map<int, int> new_freq;
        for (int &i : new_a) {
            cin >> i;
            ++new_freq[i];
        }
        
        // look for any discrepancies
        // in theory none of the frequencies should change
        // however if it does we know this object set contains the mimic, so remove all others
        rem.clear();
        int bad = -1;
        for (auto &p : new_freq) {
            if (p.second > freq[p.first]) bad = p.first; // sussy object type
        }
        if (bad != -1) {
            // discrepancy found, so let's update our `rem` vector
            // (and of course the map once this is done)
            for (int i = 0; i < new_a.size(); i++) {
                if (new_a[i] != bad) rem.push_back(i+1);
                else ans = i+1;
            }
            
            freq.clear();
            freq[bad] = new_freq[bad];
        }
        a = new_a;
    }
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T --> 0) solve();
}