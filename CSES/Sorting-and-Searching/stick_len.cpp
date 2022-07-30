// CSES Stick Lengths
 
#include <iostream>
#include <algorithm>
#include <vector>
#define int long long
using namespace std;
 
int32_t main() {
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.begin(), a.end());
    int op1 = a[(n-1) / 2], op2 = a[n/2];
    int tot1 = 0, tot2 = 0;
    for (int i = 0; i < n; i++) {
        tot1 += abs(a[i] - op1);
        tot2 += abs(a[i] - op2);
    }
    cout << min(tot1, tot2) << '\n';
}
