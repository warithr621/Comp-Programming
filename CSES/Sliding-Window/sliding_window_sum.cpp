#include <iostream>
#include <deque>
using namespace std;
#define int long long

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, k; cin >> n >> k;
    int x, a, b, c; cin >> x >> a >> b >> c;

    deque<int> window;
    int sum = 0, ans = 0;
    window.push_back(x);
    sum += x;
    for (int i = 1; i < n; i++) {
        x = (a * x + b) % c;
        window.push_back(x);
        sum += x;
        if (window.size() > k) {
            sum -= window.front();
            window.pop_front();
        }

        if (window.size() == k) {
            ans ^= sum;
        }
    }
    cout << ans << '\n';
}