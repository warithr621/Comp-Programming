#Problem: https://codeforces.com/contest/1085/problem/B

n, k = map(int, input().split())
ans = 10**9
for i in range(1, k):
    if (n % i == 0):
        ans = min(ans, n//i*k+i)
print(ans)
