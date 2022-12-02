// 2021 Silver Jan P2

#include <bits/stdc++.h>
using namespace std;
#define int long long

int N, Q, pfx[100005], sfx[100005];
string S;

void print_stack(stack<char> st) {
    cout << "PRONT "; //i love debugging
    while(!st.empty()) {
        cout << st.top() << ' ';
        st.pop();
    }
    cout << '\n';
}

void populate(int *arr) {
    stack<char> st;
    for (int i = 0; i < N; i++) {
        arr[i+1] = arr[i];
        while(!st.empty() && st.top() > S[i]) st.pop();
        if (st.empty() || st.top() < S[i]) {
            st.push(S[i]);
            ++arr[i+1];
        }
        // print_stack(st);
    }
}

signed main() {
    cin >> N >> Q >> S;
    populate(pfx);
    reverse(S.begin(), S.end());
    populate(sfx);

    while(Q--) {
        int X,Y; cin >> X >> Y;
        cout << pfx[--X] + sfx[N - Y] << '\n';
    }
}