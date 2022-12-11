// AoC 2022 D11

#include <bits/stdc++.h>
#define int long long
#define pb push_back
using namespace std;

int N, M, monke = 0, MOD = 1;
int ans[20], op[20], pr[20], dv[20], tr[20], fs[20];
string S;
vector<int> item[20];

void solver(){
	for (int i = 0; i < 10000; i++) {
		for (int j = 0; j <= monke; j++) {
			for (int k : item[j]) {
				int nk = k;
				if (op[j] == 2) nk *= k;
				if (op[j] == 1) nk *= pr[j];
				if (op[j] == 0) nk += pr[j];
				nk %= MOD;
				int add = tr[j];
				if(nk % dv[j]) add = fs[j];
				item[add].pb(nk);
				ans[j]++;
			}
			item[j].clear();
		}
	}
}

signed main() {
	freopen("input.txt", "r", stdin);

	while(getline(cin, S, ' ')){
		if(S.size() && S[0] == '~') break;
		if(S == "Monkey"){
			getline(cin, S, ':');
			monke = stoi(S);
			getline(cin, S); getline(cin, S);
			S = S.substr(18);
			for(int i = 0; i < S.size(); i += 4){
				string cur = S.substr(i, i+2);
				item[monke].pb(stoi(cur));
			}
			getline(cin, S);
			S = S.substr(23);
			
			if(S[0] == '*'){
				if(S[2] == 'o'){
					op[monke] = 2;
				}else{
					op[monke] = 1;
					pr[monke] = stoi(S.substr(2));
				}
			}else{
				op[monke] = 0;
				pr[monke] = stoi(S.substr(2));
			}
			getline(cin, S);
			S = S.substr(21);
			dv[monke] = stoi(S);
			MOD *= dv[monke];
			getline(cin, S);
			S = S.substr(29);
			
			tr[monke] = stoi(S);
			getline(cin, S);
			S = S.substr(30);
			
			fs[monke] = stoi(S);
			getline(cin, S);
		}
	}
	
	solver();
	sort(ans, ans + monke + 1);
	cout << ans[monke] * ans[monke-1];
}