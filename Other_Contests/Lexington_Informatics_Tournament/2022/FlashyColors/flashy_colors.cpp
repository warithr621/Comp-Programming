// Flashy Colors CPP

#include <iostream>
using namespace std;
int main() {
    // black is K
    string s[10] = {
        "KKBYKYBKRM",
        "BCRRBRRYMR",
        "BGKRYCYKCC",
        "RMRMYGMRWC",
        "GKYCCKWYCY",
        "GRMWBCMMKW",
        "GCKCGBRCYB",
        "MBWCMMYGCB",
        "GWGKWYCKKW",
        "BCWCMCCWBM"
    };
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j != 0) cout << ' '; // spacing separator
            
            // bools are printed as 1 (true) and 0 (false)
            
            cout << ( // red switch
                s[i][j] == 'R'
                || s[i][j] == 'M'
                || s[i][j] == 'Y'
                || s[i][j] == 'W'
            );
            
            cout << ( // green switch
                s[i][j] == 'G'
                || s[i][j] == 'C'
                || s[i][j] == 'Y'
                || s[i][j] == 'W'
            );
            
            cout << ( // blue switch
                s[i][j] == 'B'
                || s[i][j] == 'C'
                || s[i][j] == 'M'
                || s[i][j] == 'W'
            );
        }
        cout << '\n';
    }
}