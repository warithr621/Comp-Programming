#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define all(x) begin(x), end(x)
#define sz(x) (int) (x).size()
#define ll long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define vi vector<int>
#define vll vector<ll>

int n;
string s;
vector<vi> adj;
int ans = 0;

struct node {
    node* up;
    vector<node*> v;
    node(){
        up = nullptr;
        v = vector<node*>(16, nullptr);
    }
    node(node* par){
        up = par;
        v = vector<node*>(16, nullptr);
    }
};

void solve(){
    cin >> n >> s;
    vector<vi> adj(n);
    unordered_map<char, int> m;
    for(int i = 0; i < 10; ++i) m[i+'0'] = i;
    m['a'] = 10;
    m['b'] = 11;
    m['c'] = 12;
    m['d'] = 13;
    m['e'] = 14;
    m['f'] = 15;
    for (int i = 0; i < n-1; i++) {
        int u,v; cin >> u >> v;
        u--; v--;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    node* word = new node();

    function<void(int, int)> f = [&](int cur, int par){
        int& x = m[s[cur]];
        if(word->v[x] == nullptr){
            ans++;
            word->v[x] = new node(word);
        }
        word = word->v[x];
        for(auto &child : adj[cur]){
            if(child == par) continue;
            f(child, cur);
        }
        word = word->up;
    };

    for(int i = 0; i < n; i++) {
        f(i, -1); 
    }

    cout << ans << endl;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t = 1;
    while(t--) solve();
}
