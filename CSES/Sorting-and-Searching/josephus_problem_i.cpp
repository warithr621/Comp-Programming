// CSES Josephus Problem I
 
#include <bits/stdc++.h>
using namespace std;
 
void solve() {
    int n; cin >> n;
    queue<int> q;
    for (int i = 1; i <= n; i++) q.push(i);
    while(!q.empty()) {
        int skip = q.front();
        q.pop();
        q.push(skip);
        cout << q.front() << ' ';
        q.pop();
    }
}
 
int main() {
    cin.tie(0)->sync_with_stdio(0);
    solve();
}