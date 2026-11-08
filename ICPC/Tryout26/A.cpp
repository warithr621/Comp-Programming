#include <bits/stdc++.h>
using namespace std;

const int MAXN = 500005;
bool PRIME[MAXN];
int CNT[MAXN];
int ANS[MAXN];

int main() {
    fill(PRIME, PRIME + MAXN, true);
    CNT[1] = 1;
    for (int i = 2; i < MAXN; i++) {
        if (!PRIME[i]) continue;
        CNT[i]++;
        for (int j = 2*i; j < MAXN; j += i) {
            PRIME[j] = false;
            for (int k = j; k % i == 0; k /= i) CNT[j]++;
        }
    }

    // for (int i = 2; i <= 20; i++) {
    //     cout << i << ' ' << PRIME[i] << ' ' << CNT[i] << '\n';
    // }
    for (int i = 2; i < MAXN; i++) {
        CNT[i]++;
    }
    ANS[1] = 1;
    ANS[2] = 2;
    for (int i = 3; i < MAXN; i++) {
        ANS[i] = max(ANS[i-1], CNT[i]);
    }
    
    int T; cin >> T;
    while (T--) {
        int N; cin >> N;
        cout << ANS[N] << '\n';
        for (int i = 1; i <= N; i++) {
            cout << CNT[i] << ' ';
        }
        cout << '\n';
    }
}