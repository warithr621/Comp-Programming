# CSES Subarray Divisibility

import sys
read = sys.stdin.readline
write = sys.stdout.write

n = int(read())
a = list(map(int, read().split()))

mod = []
for i in range(n): mod.append(1 if i == 0 else 0);
psum = 0

for i in range(n):
    psum = ((psum + a[i]) % n + n) % n
    mod[psum] += 1

ans = 0
for i in mod:
    ans += i * (i-1) // 2

write(str(ans))
