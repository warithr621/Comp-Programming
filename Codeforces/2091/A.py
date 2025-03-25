import math
 
def in_li(num=True):
    return [*map(int if num else str, input().split())]
 
def solve():
    #code
    n = int(input())
    a = in_li()
    ans = 0
    freq = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(n):
        x = a[i]
        freq[x] += 1
        if freq[0] >= 3 and freq[1] >= 1 and freq[2] >= 2 and freq[3] >= 1 and freq[5] >= 1:
            ans = i + 1
            break
        # print(freq)
    print(ans)
 
 
t = int(read())
for quack in range(t):
    solve()