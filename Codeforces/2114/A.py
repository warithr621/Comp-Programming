import math

def solve():
    #code
    v = int(input())
    if int(math.sqrt(v)) == math.sqrt(v):
        print(0, int(math.sqrt(v)))
    else:
        print(-1) # misread this q

t = 1
t = int(input())
for quack in range(t):
    solve()