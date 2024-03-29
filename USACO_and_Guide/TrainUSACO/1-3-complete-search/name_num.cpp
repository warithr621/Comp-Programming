// USACO Trainer's "Name That Number"

/*
ID: warithr1
LANG: C++11
TASK: namenum
*/

#include <bits/stdc++.h>

int main() {
    FILE *in = fopen ("namenum.in", "r");
    FILE *in2 = fopen ("dict.txt", "r");
    FILE *out = fopen ("namenum.out","w");
    int soln = 0;
    char word[80], num[80], *p, *q, map[256];
    int i, j;
    map['A'] = map['B'] = map['C'] = '2';
    map['D'] = map['E'] = map['F'] = '3';
    map['G'] = map['H'] = map['I'] = '4';
    map['J'] = map['K'] = map['L'] = '5';
    map['M'] = map['N'] = map['O'] = '6';
    map['P'] = map['R'] = map['S'] = '7';
    map['T'] = map['U'] = map['V'] = '8';
    map['W'] = map['X'] = map['Y'] = '9';
    fscanf (in, "%s",num);
    while (fscanf (in2, "%s", word) != EOF) {
        for (p=word, q=num; *p && *q; p++, q++) {
            if (map[*p] != *q)
                break;
        }
        if (*p == '\0' && *q == '\0') {
            fprintf (out, "%s\n", word);
            soln++;
        }
    }
    if (soln == 0) fprintf(out,"NONE\n");
    return 0;
}