import math
 
def in_li(num=True):
    return [*map(int if num else str, input().split())]
 
def solve():
    #code
    n, k = map(int, input().split())
    a = in_li()
    a.sort(reverse=True)
    # print(a)
    ans = 0
    left, right = 0, 0
    while right < n:
        if a[right] * (right-left+1) >= k:
            ans += 1
            left = right+1
        right += 1
    print(ans)
 
t = int(read())
for quack in range(t):
    solve()