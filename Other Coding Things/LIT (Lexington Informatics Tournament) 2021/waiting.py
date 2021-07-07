N, M, L = map(int, input().split())
lim = 0
ans = 0
q = []
T = list(map(int, input().split()))
for i in range(N):
    inp = T[i]
    end = -1
    b = True
    while len(q) > 0 and b:
        if q[0] < inp:
            lim -= 1
            end = q[0]
            q.pop(0)
        else:
            b = False
    if end != -1 and lim == 0:
        ans += inp - end - 1
    if lim == L:
        q.append(q[0] + M)
        q.pop(0)
    if lim < L:
        q.append(inp + M - 1)
        lim += 1
print(ans)
