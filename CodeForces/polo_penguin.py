//Problem: https://codeforces.com/contest/289/problem/A

n,k = map(int, input().split())
s = 0
for _ in range(n):
    a,b = map(int, input().split())
    s += b - a + 1
print(0 if s % k == 0 else (k - s % k) % k)
