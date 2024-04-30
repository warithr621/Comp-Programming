// CSES Candy Lottery

#include <bits/stdc++.h>
using namespace std;

int main() {
	int N, K; cin >> N >> K;
	// for each 'i' from 1 to K, calculate (i / K)^N - ( (i-1) / K)^N
	double ans = 0;
	for (int i = 1; i <= K; i++) {
		double v = pow(1.0 * i / K, N) - pow((i - 1.0) / K, N);
		ans += i * v;
	}
	printf("%.6f\n", ans);
}