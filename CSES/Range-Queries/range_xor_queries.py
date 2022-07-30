# CSES Range XOR Queries

import sys
read = sys.stdin.readline
write = sys.stdout.write

n,q = map(int, read().split())
a = list(map(int, read().split()))
xor = [0] * (n+1)

for i in range(1, n+1):
    xor[i] = xor[i-1] ^ a[i-1]
    
for _ in range(q):
    l,r = map(int, read().split())
    ans = xor[r] ^ xor[l-1]
    write(str(ans) + "\n")
