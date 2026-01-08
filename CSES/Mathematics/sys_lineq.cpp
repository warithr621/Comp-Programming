#include <bits/stdc++.h>
using namespace std;
#define int long long
static const int MOD = 1'000'000'007;

int pw(int a, int e) {
    a = (a % MOD + MOD) % MOD;
    int res = 1;
    while (e) {
        if (e & 1) res = res * a % MOD;
        a = a * a % MOD;
        e >>= 1;
    }
    return res;
}
int inv(int x) {
    if (x == 0) throw invalid_argument("inv(0)");
    return pw(x, MOD-2);
}

struct Fraction {
    int v;
    Fraction(int n) {
        v = (int)((n % MOD + MOD) % MOD);
    }

    Fraction operator + (const Fraction &other) const {
        int r = v + other.v;
        if (r >= MOD) r -= MOD;
        return Fraction(r);
    }
    Fraction operator - (const Fraction &other) const {
        int r = v - other.v;
        if (r < 0) r += MOD;
        return Fraction(r);
    }
    Fraction operator * (const Fraction &other) const {
        return Fraction((v * other.v % MOD));
    }
    Fraction operator / (const Fraction &other) const {
        if (other.v == 0) throw invalid_argument("Division by zero fraction");
        return Fraction(v * inv(other.v) % MOD);
    }
    Fraction operator - () const {
        return Fraction(v ? MOD - v : 0);
    }

    Fraction& operator += (const Fraction &other) {
        return *this = *this + other;
    }
    Fraction& operator -= (const Fraction &other) {
        return *this = *this - other;
    }
    bool operator == (const Fraction &other) const {
        return v == other.v;
    }
    bool operator != (const Fraction &other) const {
        return !(*this == other);
    }
    friend ostream& operator << (ostream &os, const Fraction &f) {
        os << f.v;
        return os;
    }
};

signed main() {
	cin.tie(0)->sync_with_stdio(0);
    int n,m; cin >> n >> m;
    vector<vector<Fraction>> matrix(n, vector<Fraction>(m+1,0));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m+1; j++) {
            int x; cin >> x;
            matrix[i][j] = Fraction(x);
        }
    }

    int row = 0;
    vector<int> skib(m, -1);
    for (int col = 0; col < m && row < n; col++) {
        int nxt = row;
        while (nxt < n && matrix[nxt][col] == Fraction(0)) ++nxt;
        if (nxt == n) continue;
        swap(matrix[nxt], matrix[row]);
        skib[col] = row;
        for (int i = row+1; i < n; i++) {
            if (matrix[i][col] == Fraction(0)) continue;
            Fraction f = -matrix[i][col] / matrix[row][col];
            for (int j = col; j <= m; j++) {
                matrix[i][j] += f * matrix[row][j];
            }
        }
        row++;
    }

    for (int i = 0; i < n; i++) {
        bool z = true;
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != Fraction(0)) {
                z = false;
                break;
            }
        }
        if (z && matrix[i][m] != Fraction(0)) {
            cout << "-1\n";
            return 0;
        }
    }

    // backshots
    vector<Fraction> ans(m, Fraction(0));
    for (int i = m - 1; i >= 0; i--) {
        if (skib[i] == -1) continue;
        Fraction val = matrix[skib[i]][m];
        for (int j = i + 1; j < m; j++) {
            val -= matrix[skib[i]][j] * ans[j];
        }
        ans[i] = val / matrix[skib[i]][i];
    }

    for (int i = 0; i < m; i++) {
        cout << (skib[i] == -1 ? 0 : ans[i]) << ' ';
    }
    cout << '\n';
}
