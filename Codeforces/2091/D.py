import math

def solve():
    #code
    n, m, k = map(int, input().split())
    left, right = 1, m
    while left < right:
        mid = (left + right) // 2
        # does a longest bench of M work?
        groups, leftover = m // (mid + 1), m % (mid + 1)
        perRow = groups * mid + leftover
        if perRow * n >= k:
            right = mid
        else:
            left = mid + 1
    print(left)
 
t = int(read())
for quack in range(t):
    solve()