//Problem: 2018 December Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=855

#include <bits/stdc++.h>
using namespace std;
int c1, m1, c2, m2, c3, m3;

int main() {
    freopen("mixmilk.in", "r", stdin);
    freopen("mixmilk.out", "w", stdout);
    cin >> c1 >> m1 >> c2 >> m2 >> c3 >> m3;
    for (int i = 0; i < 100; i++) {
        if (i % 3 == 0) {
            if (m1 + m2 > c2) {
                m1 -= c2 - m2;
                m2 = c2;
            } else {
                m2 += m1;
                m1 = 0;
            }
        }
        else if (i % 3 == 1) {
            if (m2 + m3 > c3) {
                m2 -= c3 - m3;
                m3 = c3;
            } else {
                m3 += m2;
                m2 = 0;
            }
        }
        else {
            if (m3 + m1 > c1) {
                m3 -= c1 - m1;
                m1 = c1;
            } else {
                m1 += m3;
                m3 = 0;
            }
        }
    }
    cout << m1 << '\n' << m2 << '\n' << m3 << '\n';
}
