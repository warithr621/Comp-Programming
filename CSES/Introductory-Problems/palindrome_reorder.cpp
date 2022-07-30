// CSES Palindrome Reorder

#include <bits/stdc++.h>
using namespace std;
 
int main() {
    string s; cin >> s;
    if (s.size() <= 1) {
	cout << s << '\n';
	return 0;
    }
    int a[26];
    for (int i = 0; i < 26; i++) a[i] = 0;
    for (int i = 0; i < s.size(); i++) ++a[s[i] - 'A'];
    int even = 0;
    vector<char> odd;
    vector<int> o;
    for (int i = 0; i < 26; i++) {
        if (a[i] % 2 == 0 && a[i] > 0) ++even;
        else if (a[i] % 2 == 1 && a[i] > 0) {
            odd.push_back((char) (i + 'A'));
            o.push_back(a[i]);
        }
    }
    if (even > 0 && odd.size() == 0) {
        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 == 0 && a[i] > 0) {
                for (int j = 0; j < a[i]/2; j++) cout << (char) (i + 'A');
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (a[i] % 2 == 0 && a[i] > 0) {
                for (int j = 0; j < a[i]/2; j++) cout << (char) (i + 'A');
            }
        }
        cout << '\n';
    } else if (even > 0 && odd.size() == 1) {
        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 == 0 && a[i] > 0) {
                for (int j = 0; j < a[i]/2; j++) cout << (char) (i + 'A');
            }
        }
        for (int i = 0; i < o[0]; i++) cout << odd[0];
        for (int i = 25; i >= 0; i--) {
            if (a[i] % 2 == 0 && a[i] > 0) {
                for (int j = 0; j < a[i]/2; j++) cout << (char) (i + 'A');
            }
        }
        cout << '\n';
    } else cout << "NO SOLUTION\n";
}