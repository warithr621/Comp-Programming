# https://codeforces.com/contest/1731/problem/B

for _ in range(int(input())):
    N = int(input())
    print(N * (N+1) * (4*N-1) // 6 * 2022 % int(1e9+7))