# Problem: https://codeforces.com/contest/1983/problem/C

for _ in range(int(input())):
    N = int(input())
    A = [*map(int, input().split())]
    B = [*map(int, input().split())]
    C = [*map(int, input().split())]
    grid = [A, B, C]
    for i in range(3):
        grid[i] = [0] + grid[i]
    S = sum(A) # sum (in the problem, "tot")
    req = (S + 2) // 3 # the requirement
    perms = ["012", "021", "102", "120", "201", "210"]
    ans = []
    for p in perms:
        f, s, t = int(p[0]), int(p[1]), int(p[2])
        L, R, tmp = 1, 0, 0
        cur = [[], [], []]
        while R < N and tmp < req:
            tmp += grid[f][R+1]
            R += 1
        cur[f] = [L, R]
        L, tmp = R+1, 0
        while R < N and tmp < req:
            tmp += grid[s][R+1]
            R += 1
        cur[s] = [L, R]
        L, tmp = R+1, 0
        add = 0
        for i in range(L, N+1):
            add += grid[t][i]
        if add >= req:
            cur[t] = [L, N]
        if len(cur[0]) == 2 and len(cur[1]) == 2 and len(cur[2]) == 2:
            ans = cur[0] + cur[1] + cur[2]
        
    print(' '.join(map(str, ans)) if len(ans) != 0 else "-1")