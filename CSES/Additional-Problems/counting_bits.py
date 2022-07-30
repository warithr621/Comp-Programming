# CSES Counting Bits

import sys
import math

n = int(sys.stdin.readline())

dp = [1]
for i in range(1, 50):
    dp.append(2 * dp[i-1] + ((1 << (i-1)) - 1))
ans = 0
while n > 0:
    b = int(math.log2(n))
    ans += dp[b]
    b = 1 << b
    ans += n - b
    n -= b

sys.stdout.write(str(ans))