// CSES Towers

#include <iostream>
#include<vector>
using namespace std;

int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];

    vector<int> towers;
    for (int i = 0; i < n; i++) {
        //push the first block on
        if (i == 0) {
            towers.push_back(a[i]);
            continue;
        }

        //bins to look for best tower
        int L = 0, R = towers.size();
        while(L < R) {
            int M = (L+R) / 2;
            if (towers[M] > a[i]) {
                //look for one on the left side
                R = M;
            } else {
                L = M+1;
            }
        }
        if (L == (int) towers.size()) {
            //didnt work ;-;
            towers.push_back(a[i]);
        } else towers[L] = a[i];
        // for (int x : towers) cout << x << ' ';
        // cout << '\n';
    }
    cout << towers.size() << '\n';
}
