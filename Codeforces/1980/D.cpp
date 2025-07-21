// Problem: https://codeforces.com/contest/1980/problem/D

#include <bits/stdc++.h>
using namespace std;

int yip(vector<int> a) {
    int g = gcd(a[0], a[1]);
    for (int i = 1; i < a.size() - 1; i++) {
        if (g > __gcd(a[i], a[i+1])) return i;
        g = __gcd(a[i], a[i+1]);
    }
    return -1;
}

int main() {
    int T; cin >> T;
    while(T--) {
        int N; cin >> N;
        vector<int> A(N);
        for (int &i : A) cin >> i;
        int v = yip(A);
        if (v == -1) {
            cout << "YES\n";
            continue;
        }
        vector<int> f = A, s = A, t = A;
        if(v > 0) f.erase(f.begin() + v - 1);
        s.erase(s.begin() + v);
        if(v < N - 1) t.erase(t.begin() + v + 1);
        if (yip(f) == -1 || yip(s) == -1 || yip(t) == -1) {
            cout << "Yes\n";
        } else cout << "No\n";
    }
}