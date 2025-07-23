// CSES Candy Lottery
 
#include <bits/stdc++.h>
using namespace std;
 
double goofy(double x, int digits) {
	// lowk GPTed oops
	double scale = pow(10, digits);
	double scaled = x * scale;
	double intpart, frac = modf(scaled, &intpart);
	if (fabs(frac - 0.5) < 1e-12) {
		if (fmod(intpart, 2.0) == 0) {
			scaled = intpart;
		} else {
			scaled = intpart + 1;
		}
	} else {
		scaled = round(scaled);
	}
	return scaled / scale;
}


int main() {
	int N, K; cin >> N >> K;
	// for each 'i' from 1 to K, calculate (i / K)^N - ( (i-1) / K)^N
	double ans = 0;
	for (int i = 1; i <= K; i++) {
		double v = pow(1.0 * i / K, N) - pow((i - 1.0) / K, N);
		ans += i * v;
	}
	printf("%.6f\n", goofy(ans, 6));
}