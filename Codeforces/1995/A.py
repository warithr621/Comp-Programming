# https://codeforces.com/contest/1995/problem/A

import sys
read = sys.stdin.readline
write = sys.stdout.write

for _ in range(int(read())):
    n, k = map(int, read().split())
    ans, sz, flip = 0, n, True
    while k != 0:
        # print(k, sz)
        k, ans = k - sz, ans + 1
        if k <= 0: break
        if flip:
            sz -= 1
        flip = not flip
    write(str(ans) + '\n')