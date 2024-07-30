# https://codeforces.com/contest/1991/problem/A

import sys
read = sys.stdin.readline
write = sys.stdout.write

for _ in range(int(read())):
    n = int(read())
    a = [*map(int, read().split())]
    ans = -1
    for i in range(0, n, 2):
        ans = max(ans, a[i])
    write(str(ans) + '\n')