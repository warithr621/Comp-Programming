//Source: 2020 Lexington Informatics Tournament Standard Round A (Waiting)

#include <bits/stdc++.h>
using namespace std;
#define poll(v) v.erase(v.begin(), v.begin() + 1);
#define pb(x) push_back(x);

int main() {
    int N, M, L, lim = 0, ans = 0, inp, end;
    cin >> N >> M >> L;
    vector<int> vi;
    while(N--) {
        cin >> inp; end = -1;
        bool b = true;
        while(vi.size() > 0 && b) {
            if (vi[0] < inp) {
                --lim;
                end = vi[0];
                poll(vi)
            } else b = false;
        }
        if (end != -1 && lim == 0) {
            ans += inp - end - 1;
        }
        if (lim == L) {
            vi.pb(vi[0] + M);
            poll(vi);
        }
        if (lim < L) {
            vi.pb(inp + M - 1);
            ++lim;
        }
    }
    cout << ans << '\n';
}
