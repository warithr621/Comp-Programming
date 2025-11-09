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
    int n; cin >> n;
    vector<int> v(n);
    for(auto & i : v) cin >> i;
    int mod2 = 0, mod5 = 0;
    for(auto val : v){
        if(val%2==0) mod2++;
        if(val%5==0) mod5++;
    }
    if(mod2 == n || mod5 == n){
        cout << n << endl;
    }else{
        cout << 1 << endl;
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t = 1; 
    while(t--) solve();
}
