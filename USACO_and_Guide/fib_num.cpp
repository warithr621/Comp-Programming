// CSES Fibonacci Numbers

#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#define int long long
using namespace std;
//wow pointers are more confusing than I thought

int** matrix_mult(int** a, int** b) {
    int** ans = 0;
    ans = new int*[2];
    for (int i = 0; i < 2; i++) ans[i] = new int[2];
    
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                ans[i][j] += a[i][k] * b[k][j];
                ans[i][j] %= 1000000007;
            }
        }
    }
    
    return ans;
}

int32_t main() {
    int n; cin >> n;
    
    int** m = new int*[2];
    int** init = new int*[2];
    for (int i = 0; i < 2; i++) {
        m[i] = new int[2]; init[i] = new int[2];
    }
    
    m[0][1] = m[1][0] = m[0][0] = 1;
    m[1][1] = 0;
    init[0][0] = init[1][1] = 1;
    init[0][1] = init[1][0] = 0;
    
    for (; n > 0; n /= 2) {
        if (n & 1) init = matrix_mult(init, m);
        m = matrix_mult(m, m);
    }
    cout << init[0][1] << '\n';
}