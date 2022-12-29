// USACO Trainer's "Transformations"

/*
ID: warithr1
LANG: C++11
TASK: transform
*/

#include <bits/stdc++.h>
using namespace std;

int N;
char F[11][11], S[11][11];

bool cmp() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (F[i][j] != S[i][j]) return false;
        }
    }
    return true;
}

void rot() {
    for (int i = 0; i < N/2; i++) {
        for (int j = i; j < N-i-1; ++j) {
            char tmp = F[i][j];
            F[i][j] = F[N-1-j][i];
            F[N-1-j][i] = F[N-1-i][N-1-j];
            F[N-1-i][N-1-j] = F[j][N-1-i];
            F[j][N-1-i] = tmp;
        }
    }
}

void ref() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N/2; j++) {
            char tmp = F[i][j];
            F[i][j] = F[i][N-j-1];
            F[i][N-j-1] = tmp;
        }
    }
}

void ct() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cout << F[i][j];
        }
        cout << '\n';
    }
}

int main() {
    freopen("transform.in", "r", stdin);
    freopen("transform.out", "w", stdout);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> F[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> S[i];
    }

    // ct(); ref(); ct(); ref();

    for (int i = 1; i <= 3; i++) {
        rot();
        if (cmp()) {
            cout << i << '\n';
            return 0;
        }
    }
    rot(); // back to normal

    ref();
    if (cmp()) {
        cout << "4\n";
        return 0;
    }
    
    for (int i = 1; i <= 3; i++) {
        rot();
        if (cmp()) {
            cout << "5\n";
            return 0;
        }
    }
    rot(); ref(); // back to normal

    cout << (cmp() ? 6 : 7) << '\n';
}   