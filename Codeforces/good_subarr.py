# https://codeforces.com/contest/1398/problem/C

import sys
read = sys.stdin.readline
write = sys.stdout.write

def solve():
    n = int(read())
    s = read()

    diff = {0: 1}
    ans = 0
    psum = 0

    for i in range(n):
        psum += int(s[i])
        pos = psum - i - 1
        if pos not in diff: diff[pos] = 0;
        diff[pos] += 1
        ans += diff[pos] - 1
        
    write(str(ans) + '\n')

for _ in range(int(read())): solve();