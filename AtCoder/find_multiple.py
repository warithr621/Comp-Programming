#Problem: https://atcoder.jp/contests/abc220/tasks/abc220_a

import math
a,b,c = map(int, input().split())
A = math.ceil(a/c)
B = math.floor(b/c)
print(-1 if A > B else c * A)
