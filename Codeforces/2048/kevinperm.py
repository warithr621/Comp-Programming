for t in range(int(input())):
    n, k = map(int, input().split())
    ans = [0 for _ in range(n)]
    cur = 1
    for i in range(k-1, n, k):
        ans[i] = cur
        cur += 1
    for i in range(n):
        if ans[i] == 0:
            ans[i] = cur
            cur += 1
    print(' '.join(map(str, ans)))