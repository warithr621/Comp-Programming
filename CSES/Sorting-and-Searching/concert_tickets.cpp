// CSES Concert Tickets

#include <iostream>
#include <set>
#include <iterator>
using namespace std;

int main() {
    multiset<int> ms;
    int n,m; cin >> n >> m;
    while(n--) {
        int h; cin >> h;
        ms.insert(h);
    }
    while(m--) {
        int t; cin >> t;
        multiset<int>::iterator itr = ms.upper_bound(t);
        if (itr == ms.begin()) cout << "-1\n";
        else {
            cout << *(--itr) << "\n";
            ms.erase(itr);
        }
    }
}
