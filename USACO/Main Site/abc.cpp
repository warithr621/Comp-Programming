//Problem: 2020 December Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=1059

#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> a(7);
    for (int i = 0; i < 7; i++) cin >> a[i];
    sort(a.begin(), a.end());
    cout << a[0] << " " << a[1] << " " << (a[0] + a[1] == a[2] ? a[3] : a[2]) << '\n';
}
