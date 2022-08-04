// https://codeforces.com/contest/1716/problem/B

#include <bits/stdc++.h>
using namespace std;
#define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
#define order(v) sort(v.begin(), v.end())
#define rev(v) sort(v.rbegin(), v.rend())
#define pb(x) push_back(x)
#define forn(i, ty) for(int i = 0; i < ty; i++)
 
int a[150];
int n;
 
void print() {
    for (int i = 1; i <= n; i++) cout << a[i] << ' ';
    cout << '\n';
}
 
void twice() {
    //code
    cin >> n;
    cout << n << '\n';
    for (int i = 1; i <= n; i++) a[i] = i;
    print();
    swap(a[1], a[n]);
    print();
    for (int i = 2; i < n; i++) {
        swap(a[i], a[n]);
        print();
    }
 
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) twice();
}