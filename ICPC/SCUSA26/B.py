# warith

n, a, b, c = map(int, input().split())
towers = [a-1,b-1,c-1]

def f(s, e, b):
    if e < s:
        e += n
    ops = [e-b, e+b]
    l, r = abs(ops[0] - s), abs(ops[1]%n - s)
    l = min(l, n-l)
    r = min(r, n-r)
    ans = [min(l,r), max(l,r)]
    if ops[0] <= s <= ops[1] or ops[0] <= s+n <= ops[1]:
        ans[0] = 0
    if ops[0] <= s + n//2 <= ops[1]:
        ans[1] = n // 2
    # print(s, e, b, ops, tuple(ans))
    return tuple(ans)

def intersect(a, b):
    if a is None or b is None:
        return None
    if a > b:
        a,b = b,a
    if a[1] < b[0]:
        return None
    return (max(a[0], b[0]), min(a[1], b[1]))

L, R = 0, n-1
while L < R:
    M = L + (R - L) // 2
    cur = f(towers[0], towers[1], M)
    for x,y in [(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)]:
        cur = intersect(cur, f(towers[x], towers[y], M))
    # print(M, cur)
    if cur is not None:
        R = M
    else:
        L = M + 1
print(L)