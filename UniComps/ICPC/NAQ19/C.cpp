// 2019 NAQ: Gerrymandering

#include <bits/stdc++.h>
using namespace std;

int main() {
    int P, D; cin >> P >> D;
    vector< pair<int, int> > dist(D+1, {0,0});
    for (int i = 0; i < P; i++) {
        int d, a, b; cin >> d >> a >> b;
        dist[d] = {dist[d].first + a, dist[d].second + b};
    }
    int v = 0, wa = 0, wb = 0;
    for (int i = 1; i <= D; i++) {
        auto p = dist[i];
        int A = p.first, B = p.second, req = A + B;
        if (p.first > p.second) {
            cout << "A " << A - (req / 2 + 1) << ' ' << B << '\n';
            wa += A - (req / 2 + 1);
            wb += B;
        } else {
            cout << "B " << A << ' ' << B - (req / 2 + 1) << '\n';
            wa += A;
            wb += B - (req / 2 + 1);
        }
        v += A + B;
    }
    cout << setprecision(10) << 1.0 * abs(wa - wb) / v;
}