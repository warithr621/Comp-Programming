//Problem: https://codeforces.com/contest/987/problem/B

import math
x,y = map(int, input().split())
a = y * math.log(x)
b = x * math.log(y)
if abs(a-b) < 1e-9:
    print('=')
else:
    print('<' if a < b else '>')
