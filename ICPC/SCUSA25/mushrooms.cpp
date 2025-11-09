#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int) (x).size()
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define vi vector<int>
#define vll vector<ll>

void solve(){
    int r, c; cin >> r >> c;
    if(r >= 3){
        if(c == 1){
            cout << 1 << endl;
        }else{
            cout << -1 << endl;
        }
    }else{
        if(r == 1){
            cout << (c+2)/3 << endl;
        }else{
            cout << c/2 + 1 << endl;
        }
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t = 1;
    while(t--) solve();
}
