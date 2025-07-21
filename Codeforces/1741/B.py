# https://codeforces.com/contest/1741/problem/B

for _ in range(int(input())):
    N = int(input())
    print("-1" if N == 3 else (' '.join(map(str, [i for i in range(3, N+1)]))) + " 2 1")