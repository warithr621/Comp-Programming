// nick

#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    int l, r; cin >> l >> r;
    l %= 10;
    r %= 10;
    if (l == 6 && r == 7) {
        cout << 0;
        return 0;
    }
    if (l > r)
        swap(l, r);
    if (l == 7 || r == 7) {
        if (l == 7)
            swap(l, r);
        if (l == 6)
            cout << 10;
        else if (l < 6)
            cout << 6 - l;
        else
            cout << 16 - l;
    } else if (l == 6 || r == 6) {
        if (l == 6)
            swap(l, r);
         if (l == 6)
            cout << 11;
        else if (l < 6)
            cout << 6 - l + 1;
        else
            cout << 16 - l + 1;
    } else {
        int sum = 0;
        if (l < 6)
            sum += 6 - l;
        else
            sum += 16 - l;
        if (r < 7)
            sum += 7 - r;
        else
            sum += 17 - r;
        cout << sum;
    }

    return 0;
}