# CSES Missing Coin Sum

import sys
read = sys.stdin.readline
write = sys.stdout.write
 
n = int(read())
a = sorted(list(map(int, read().split())))
 
res = 1
for i in range(n):
    if a[i] > res:
        break
    else:
        res += a[i]
        
write(str(res) + '\n')