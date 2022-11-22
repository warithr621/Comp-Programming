# Problem: https://codeforces.com/problemset/problem/463/B

n = int(input())
L = list(map(int, input().split()))
x = 0
ans = 0
e = 0
for i in range(n):
    e += x - L[i]
    if e < 0:
        ans += abs(e)
        e = 0
    x = L[i]
print(ans)
