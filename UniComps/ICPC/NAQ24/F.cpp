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
%:define forn(i, n) for(int i = 0; i < n; ++i)

void solve() <%
    //code
    double x1, y1, x2, y2, a;
    cin >> x1 >> y1 >> x2 >> y2 >> a;
    // (x1, y1) and (x2, y2) are foci
    // a is MAJOR AXIS
    double cx = (x1 + x2) / 2, cy = (y1 + y2) / 2;
    // (cx, cy) is the center of the ellipse
    a /= 2; // a is now SEMI-MAJOR AXIS
    double c = sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) / 2;
    // c is the focus length, rmbr c^2 = a^2 - b^2
    double b = sqrt(a*a - c*c);

    double theta = atan2(y2 - y1, x2 - x1);
    vector<double> ex(2000), ey(2000); // this is so troll
    for (int i = 0; i < 2000; i++) {
        double angle = 2 * M_PI * i / 2000;
        double x = a * cos(angle), y = b * sin(angle);
        double xrot = x * cos(theta) - y * sin(theta);
        double yrot = x * sin(theta) + y * cos(theta);
        ex[i] = xrot + cx;
        ey[i] = yrot + cy;
    }
    cout << setprecision(8);
    cout << *min_element(ex.begin(), ex.end()) << ' ';
    cout << *min_element(ey.begin(), ey.end()) << ' ';
    cout << *max_element(ex.begin(), ex.end()) << ' ';
    cout << *max_element(ey.begin(), ey.end()) << ' ';
%>
 
signed main() <%
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    // cin >> T;
    while (T --> 0) solve();
%>
