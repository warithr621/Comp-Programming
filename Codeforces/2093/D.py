def recurse(n, x, y):
    if n == 0:
        return 0
    n -= 1
    if x < (1 << n) and y < (1 << n):
        return recurse(n, x, y)
    elif x >= (1 << n) and y >= (1 << n):
        return recurse(n, x - (1 << n), y - (1 << n)) + (1 << (2*n))
    elif x >= (1 << n):
        return recurse(n, x - (1 << n), y) + 2 * (1 << (2 * n))
    else:
        return recurse(n, x, y - (1 << n)) + 3 * (1 << (2 * n))

def recurse2(n, d):
    if n == 0:
        return [0, 0]
    n -= 1
    if d < (1 << (2 * n)):
        return recurse2(n, d)
    d -= (1 << (2 * n))
    if d < (1 << (2 * n)):
        res = recurse2(n, d)
        return [(1 << n) + res[0], (1 << n) + res[1]]
    d -= (1 << (2 * n))
    if d < (1 << (2 * n)):
        res = recurse2(n, d)
        return [(1 << n) + res[0], res[1]]
    d -= (1 << (2 * n))
    res = recurse2(n, d)
    return [res[0], (1 << n) + res[1]]
    
    

def solve():
    # code
    n = int(input())
    q = int(input())
    for _ in range(q):
        query = input().split()
        if query[0] == '->':
            x, y = int(query[1]), int(query[2])
            print(recurse(n, x-1, y-1) + 1)
        else:
            d = int(query[1])
            ans = recurse2(n, d-1)
            print(ans[0] + 1, ans[1] + 1)

t = int(input())
for quack in range(t):
    solve()