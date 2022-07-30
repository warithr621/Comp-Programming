#Problem: https://codeforces.com/contest/1136/problem/B

n,k = map(int, input().split())
print(3*n + min(n-k,k-1))
