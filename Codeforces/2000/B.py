# https://codeforces.com/contest/2000/problem/B

def solve():
    N = int(input())
    A = [*map(int, input().split())]
    taken = [False for _ in range(N+1)]
    taken[A[0]] = True
    for i in range(1, N):
        X = A[i]
        if X == 1:
            if taken[2] == False:
                return "NO"
        elif X == N:
            if taken[N-1] == False:
                return "NO"
        else:
            if taken[X+1] == False and taken[X-1] == False:
                return "NO"
        taken[X] = True
    return "YES"

for _ in range(int(input())):
    print(solve())