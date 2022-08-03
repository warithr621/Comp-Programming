/*
ID: REDACTED
LANG: C++11
TASK: pprime
*/

#include <bits/stdc++.h>
using namespace std;

const int N = 100000002;
vector<int> pal;

bool prime(int x) {
    if (x <= 1) return false;
    if (x <= 3) return true;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return 0;
    }
    return 1;
}

int make(int inp, int b, bool odd) {
    int n = inp, p = inp;
    if (odd) n /= b;
    while (n > 0) {
        p = p * b + n%b;
        n /= b;
    }
    return p;
}

void next(string &s) {
    int len = s.length();
    for (int n = (len+1) / 2; n > 0; --n) {
        if (s[n-1] < '9') {
            s[len-n] = s[n-1] = s[n-1] + 1;
            return;
        } else {
            s[len-n] = s[n-1] = '0';
        }
    }
    s[0]++;
    s.push_back(s[0]);
}

void pal_gen() {
    pal.push_back(0);
    string s = "0";
    while(true) {
        next(s);
        if ((int) s.length() > 8) break;
        pal.push_back(stoi(s));
    }
}

int main() {
    pal_gen();
    
    freopen("pprime.in", "r", stdin);
    freopen("pprime.out", "w", stdout);
    int a,b; cin >> a >> b;
    
    for (int i = 0; i < (int)pal.size(); i++) {
        if (pal[i] < a) continue;
        if (pal[i] > b) break;
        if (prime(pal[i])) cout << pal[i] << '\n';
    }
}
