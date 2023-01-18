// 2016 Feb Silver P3

#include <bits/stdc++.h>
using namespace std;

int X, Y, K, M;
bool poss[105][105] = {false};

int main() {
    freopen("pails.in", "r", stdin);
    freopen("pails.out", "w", stdout);
    
    poss[0][0] = true;
    cin >> X >> Y >> K >> M;
    // poss[A][B] == true --> can make A in left and B in right
    
    while(K--) {
        bool tst[105][105] = {false};
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                if (!poss[i][j]) continue;
                tst[i][j] = true;
                
                // empty X and Y
                tst[0][j] = tst[i][0] = true;
                
                // fill X and Y
                tst[X][j] = tst[i][Y] = true;
                
                // yeet stuff to left and right
                int mvr = min(i, Y-j), mvl = min(X-i, j);
                tst[i-mvr][j+mvr] = tst[i+mvl][j-mvl] = true;
            }
        }
        memcpy(poss, tst, sizeof(poss));
    }
    
    int best = 69420;
    for (int i = 0; i <= X; i++) {
        for (int j = 0; j <= Y; j++) {
            if (poss[i][j]) best = min(best, abs(i+j-M));
        }
    }
    
    cout << best << '\n';
}