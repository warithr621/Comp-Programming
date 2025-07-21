# https://codeforces.com/contest/1717/problem/C

import sys
read = sys.stdin.readline
write = sys.stdout.write

for _ in range(int(input())):
    n = int(read())
    a = list(map(int, read().split()))
    b = list(map(int, read().split()))
    a.append(a[0]); b.append(b[0]);
    
    w = True
    for i in range(n+1):
        w &= a[i] <= b[i]
    
    for i in range(n):
        w &= (a[i] == b[i]) or (b[i] <= b[i+1] + 1)
        
    write("YES\n" if w else "NO\n")