import math
 
def solve():
    #code
    n = int(input())
    if n % 2 == 0:
        print(-1)
        return
    a = []
    for i in range(1, n+1, 2):
        a.append(i)
    for i in range(2, n, 2):
        a.append(i)
    print(' '.join(map(str, a)))
 
t = int(read())
for quack in range(t):
    solve()