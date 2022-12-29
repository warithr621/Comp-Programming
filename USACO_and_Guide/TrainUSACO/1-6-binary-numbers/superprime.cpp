// USACO Trainer's "SuperPrime Rib"

/*
ID: warithr1
LANG: C++11
TASK: sprime
*/

#include <bits/stdc++.h>
using namespace std;

vector<int> apd = {1, 3, 7, 9};

bool prime(int x) {
    if (x <= 1) return false;
    if (x <= 3) return true;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return 0;
    }
    return 1;
}

set<int> upd(set<int> orig) {
    set<int> ret;
    for (auto x : orig) {
        for (int i : apd) {
            if (prime(10 * x + i)) ret.insert(10*x+i);
        }
    }
    return ret;
}

int main() {
    freopen("sprime.in", "r", stdin);
    freopen("sprime.out", "w", stdout);

    int N; cin >> N;
    set<int> primes;
    primes.insert(2); primes.insert(3); primes.insert(5); primes.insert(7);
    int len = 1;
    while(len != N) {
        primes = upd(primes);
        ++len;
    }
    for (auto x : primes) cout << x << '\n';
}