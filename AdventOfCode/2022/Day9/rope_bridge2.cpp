// AoC 2022 D9

#include <bits/stdc++.h>
using namespace std;

string S;
set<pair<int, int>> st;
int ax[10], ay[10], apx[10], apy[10];
int dx[8] = {-1,-1,-1,0,0,1,1,1}, dy[8] = {-1,0,1,-1,1,-1,0,1};

int dist(int a, int b, int c, int d) {
	return abs(a-c) + abs(b-d);
}

void do_stuff() {
	char d = S[0];
	int mv = stoi(S.substr(2));
	while (mv--) {
		for(int j = 0; j < 10; j++){
			apx[j] = ax[j];
			apy[j] = ay[j];
		}
		if(d == 'U') ay[0]++;
		if(d == 'D') ay[0]--;
		if(d == 'L') ax[0]--;
		if(d == 'R') ax[0]++;

		for(int j = 1; j < 10; j++){
			if (abs(ax[j] - ax[j-1]) > 1 || abs(ay[j] - ay[j-1]) > 1) {
				int mn = 1e9, idx = 0;
				for(int k = 0; k < 8; k++){
					int cur = dist(ax[j]+dx[k], ay[j]+dy[k], ax[j-1], ay[j-1]);
					if(cur < mn){
						mn = cur;
						idx = k;
					}
				}
				ax[j] += dx[idx];
				ay[j] += dy[idx];
			}
		}
		st.insert({ax[9], ay[9]});
	}
}

int main() {
	freopen("input.txt", "r", stdin);

	while(getline(cin, S)) {
		if (S.size() == 0) break;
		do_stuff();
	}

	cout << st.size() << '\n';
}