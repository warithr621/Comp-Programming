// 2022 Open Silver P2

#include <bits/stdc++.h>
using namespace std;

string S, T, sub;
int Q;
bool works[26][26];

bool test(char x, char y) {
    string s = "", t = "";
    for (int i = 0; i < S.size(); i++) {
        if (S[i] == x || S[i] == y) s += S[i];
    }
    for (int i = 0; i < T.size(); ++i) {
        if (T[i] == x || T[i] == y) t += T[i];
    }

    return s == t;
}

int main() {
    cin.tie(0)->sync_with_stdio(0); // lol this brought down TC times from ~1k ms to ~570 ms

    cin >> S >> T >> Q;
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
            works[i][j] = test((char) (i+'a'), (char) (j+'a'));
        }
    }

    while(Q--) {
        cin >> sub;
        bool yay = true;
        for (int i = 0; i < sub.size(); ++i) {
            for (int j = 0; j < sub.size(); ++j) {
                yay &= works[sub[i] - 'a'][sub[j] - 'a'];
            }
        }

        cout << (yay ? "Y" : "N");
    }

}