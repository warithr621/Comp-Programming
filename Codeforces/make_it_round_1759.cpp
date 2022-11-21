// https://codeforces.com/contest/1759/problem/D

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

int log2(int x) {
    int cnt = 0;
    while((x & 1) != 1) {
        ++cnt;
        x >>= 1;
    }
    return cnt;
}
 
int log5(int x) {
    int cnt = 0;
    while(x % 5 == 0) {
        ++cnt;
        x /= 5;
    }
    return cnt;
}

void solve() {
    //code
    int n,m; cin >> n >> m;
 
    int two = log2(n), five = log5(n);
 
    //first goal is to makes 5 count = 2 count
    //then make 2 count = 5 count
    //then spam 2 5
    //then get biggest multiple after spam
 
    int mult = 1;
    while(five < two && mult * 5 <= m) {
        mult *= 5;
        ++five;
    }
    // cout << "CHECK: " << mult << '\n';
    while(two < five && mult * 2 <= m) {
        mult <<= 1;
        ++two;
    }
    // cout << "CHECK: " << mult << '\n';
    while(mult * 10 <= m) {
        mult *= 10;
    }
    // cout << "CHECK: " << mult << '\n';
 
    int k = m / mult * mult;
 
    cout << n*k << '\n';
}
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}