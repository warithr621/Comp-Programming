// 2022 NAQ: Ghost Leg

#include <bits/stdc++.h>
using namespace std;

int main() {
	int N, M; cin >> N >> M;
	int A[M], B[N];
	for (int &i : A) cin >> i;
	for (int i = 1; i <= N; i++) {
	    int ptr = i;
	    for (int x : A) {
	        if (ptr == x) ptr++;
	        else if (ptr == x+1) ptr--;
	    }
	    B[ptr-1] = i;
	}
	for (int x : B) cout << x << '\n';
}
