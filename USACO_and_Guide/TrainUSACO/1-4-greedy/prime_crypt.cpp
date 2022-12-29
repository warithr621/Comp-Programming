// USACO Trainer's "Prime Cryptagram"

/*
ID: warithr1
LANG: C++11
TASK: crypt1
*/

#include <bits/stdc++.h>
using namespace std;

bool good[10];

bool yay(int x) {
    bool ans = true;
    while(x != 0) {
        ans &= good[x%10];
        x /= 10;
    }
    return ans;
}

int main() {
    freopen("crypt1.in", "r", stdin);
    freopen("crypt1.out", "w", stdout);

    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        int x; cin >> x;
        good[x] = true;
    }

    int ans = 0;
    for (int big = 100; big <= 1000; ++big) {
        for (int small = 10; small <= 100; ++small) {
            if (!yay(big) || !yay(small)) continue;
            int f = big * (small / 10);
            int s = big * (small % 10);
            if (100<=f&&f<=1000 && 100<=s&&s<=1000 && yay(f)&&yay(s)) {
                int prod = 10*f+s;
                if (1000<=prod&&prod<=10000 && yay(prod)) {
                    ++ans;
                }
            }
        }
    }

    cout << ans << '\n';
}   