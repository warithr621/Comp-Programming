
/*
Im Nayeon
Yoo Jeongyeon
Momo Jjang
Sana Jjang
Park Jihyo
Mina Jjang
Kim Dahyun
Son Chaeyoung
Chou Tzuyu
One in a million
눈부시게 사랑해
트와이스 !!
*/

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(a) sort(a.begin(), a.end())
%:define rev(a) sort(a.rbegin(), a.rend())
%:define pb(x) push_back(x)
const double PI = 3.141592653589793;

void solve() <%
    //code
	// cout << atan2(1, 1) << '\n' << atan2(1, -1) << '\n' << atan2(-1, -1) << '\n' << atan2(-1, 1) << '\n';
    int n; double r; cin >> n >> r;
    double a[n], b[n], c[n];
    for (int i = 0; i < n; i++) {
    	cin >> a[i] >> b[i] >> c[i];
    }
    double best = 0;
    for (int i = 0; i < n; i++) {
    	double A = a[i], B = b[i], C = c[i];
    	if (a[i] == 0 && b[i] != 0) {
    		// By + C = 0 --> y = -C/B
    		// x^2 + y^2 = r^2
    		// find x s.t. x^2 + (C/B)^2 = r^2
    		double X = r*r - (C/B)*(C/B);
    		double xl = -sqrt(X), xr = -xl;
    		// cout << "~" << xl << ' ' << xr << '\n';
    		double theta = asin(xr / r);
    		theta *= 2;
    		double area = 0.5 * r * r * (theta - sin(theta));
    		double ratio = area / (PI * r * r);
    		best = max(best, ratio);
    	} else if (b[i] == 0 && a[i] != 0) {

    		// Ax + C = 0 --> x = -C/A
    		// x^2 + y^2 = r^2
    		double Y = r*r - (C/A)*(C/A);
    		double yl = -sqrt(Y), yr = -yl;
    		// cout << "~" << yl << ' ' << yr << '\n';
    		double theta = asin(yr / r);
    		theta *= 2;
    		double area = 0.5 * r * r * (theta - sin(theta));
    		double ratio = area / (PI * r * r);
    		best = max(best, ratio);
    	} else if (a[i] != 0 && b[i] != 0) {
    		// Ax + By + C = 0 --> y = (-C - Ax) / B
    		// x^2 + y^2 = r^2
    		// B^2 x^2 + (Ax + C)^2 = (Br)^2
    		// (A^2 + B^2)x^2 + (2AC)x + (C^2 - (Br)^2) = 0
    		double a = A*A + B*B, b = 2*A*C, c = C*C - B*B*r*r;
    		double d = sqrt(b*b - 4 * a * c);
    		double x1 = (-b - d) / (2 * a);
    		double x2 = (-b + d) / (2 * a);
    		// y = (-C - Ax) / B
    		double y1 = (-C - A * x1) / B;
    		double y2 = (-C - A * x2) / B;
    		// cout << x1 << ' ' << y1 << '\n';
    		// cout << x2 << ' ' << y2 << '\n';
    		double t1 = atan2(y1, x1), t2 = atan2(y2, x2);
    		if (t1 < 0) t1 = 2 * PI + t1;
    		if (t2 < 0) t2 = 2 * PI + t2;
    		// cout << t1 << ' ' << t2 << '\n';
    		double diff = abs(t1 - t2);
    		diff = min(diff, 2 * PI - diff);
    		double area = 0.5 * r * r * (diff - sin(diff));
    		double ratio = area / (PI * r * r);
    		best = max(best, ratio);
    	}
    }
    cout << setprecision(8) << best << ' ' << 1-best << '\n';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
