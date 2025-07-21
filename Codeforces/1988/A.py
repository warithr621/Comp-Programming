# https://codeforces.com/contest/1988/problem/A

for _ in range(int(input())):
    n, k = map(int, input().split())
    # ans is ceil( (n-1) / (k-1) )
    print( (n - 1 + k - 2) // (k - 1) )