//Problem: 2015 December Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=567

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("paint.in", "r", stdin);
    freopen("paint.out", "w", stdout);
    int a,b,c,d; cin >> a >> b >> c >> d;
    if (c < a) {
        swap(a,c); swap(b,d);
    }
    if (c >= b) cout << b + d - a - c;
    else cout << (d > b ? d-a : b-a);
}
