// USACO Trainer's "Barn Repair"

/*
ID: warithr1
LANG: C++11
TASK: barn1
*/

#include <bits/stdc++.h>
using namespace std;

#define MAX 200
int hascow[MAX];

int main() {
    freopen("barn1.in", "r", stdin);
    freopen("barn1.out", "w", stdout);
    int M, S, C, i, j, c, lo, hi, nrun;
    int run[MAX];

    cin >> M >> S >> C;
    for (int i = 0; i < C; i++) {
        int x; cin >> x;
        hascow[x-1] = true;
    }

    int uncovered = 0;
    for (i = 0; i < S && !hascow[i]; i++) ++uncovered;
    lo = i;
    for(i = S-1; i>=0 && !hascow[i]; --i) ++uncovered;
    hi = i+1;

    nrun = 0;
    i = lo;
    while(i < hi) {
        while (hascow[i] && i < hi) i++;

        for(j = i; j < hi && !hascow[j]; j++) {}

        run[nrun++] = j-i;
        i = j;
    }

    sort(run, run + nrun, greater<int>());
    for(i = 0; i < nrun && i < M-1; i++) uncovered += run[i];
    cout << S - uncovered << '\n';
}