// CSES Tower of Hanoi

#include <bits/stdc++.h>
using namespace std;
 
void tower(int d, int s, int i, int e) {
    if (d == 1) {
        cout << s << " " << e << '\n';
        return;
    }
    tower(d-1, s, e, i);
    cout << s << " " << e << '\n';
    tower(d-1, i, s, e);
}
 
int main() {
    int n; cin >> n;
    cout << (1 << n) - 1 << '\n';
    tower(n, 1, 2, 3);
}