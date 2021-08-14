#Problem: https://codeforces.com/contest/1108/problem/B
n = int(input())
L = list(map(int, input().split()))
x = max(L)
for i in range(1, x+1):
    if x % i == 0:
        L.remove(i)
print(x, max(L))
