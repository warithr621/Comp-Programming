# https://codeforces.com/contest/1733/problem/A

for _ in range(int(input())):
    n,k = map(int, input().split())
    a = list(map(int, input().split()))
    ans = [0] * (k+1)
    for i in range(n):
        ans[i%k] = max(ans[i%k], a[i])
    
    tot = 0
    for i in range(k):
        tot += ans[i]
    print(tot)