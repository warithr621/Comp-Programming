# https://codeforces.com/contest/1845/problem/A

for _ in range(int(input())):
    N, K, X = map(int, input().split())
    if X != 1:
        print("YES")
        print(N)
        print("1 " * N)
    elif K == 1 or (K == 2 and N % 2 == 1):
        print("NO")
    else:
        print("YES")
        print(N // 2)
        print(N % 2 + 2, "2 " * (N // 2 - 1))
        