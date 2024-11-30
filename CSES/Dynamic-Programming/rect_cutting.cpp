// CSES Rectangle Cutting

#include <bits/stdc++.h>
using namespace std;
vector< vector<int> > dp;

int find(int x, int y) {
	if (x < y) swap(x,y);
	return dp[x][y];
}

int main() {
	int a,b; cin >> a >> b;
	if (a < b) swap(a,b);
	dp = vector< vector<int> >(a+1, vector<int>(a+1, 0));
	// do it for a row rectangle (like a 1 x 5)
	for (int i = 1; i <= a; i++)
		dp[i][1] = i - 1;
	for (int i = 2; i <= a; i++) {
		for (int j = 2; j <= b; j++) {
			if (dp[i][j] != 0) continue;
			if (i == j) {
				dp[i][j] == 0; continue;
			}
			dp[i][j] = 1'000'000;
			// find the number of ways to cut it
			for (int ii = 1; ii < i; ii++)
				dp[i][j] = min(dp[i][j], 1 + find(ii, j) + find(i - ii, j));
			for (int jj = 1; jj < j; jj++)
				dp[i][j] = min(dp[i][j], 1 + find(i, jj) + find(i, j - jj));
		}
	}
	// for (int i = 1; i <= a; i++) {
	// 	for (int j = 1; j <= b; j++)
	// 		cout << "(" << i << ", " << j << "): " << find(i,j) << " ~ ";
	// 	cout << '\n';
	// }

	cout << find(a,b) << '\n';
}