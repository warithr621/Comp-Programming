# https://codeforces.com/contest/1779/problem/B

def solve():
    N = int(input())
    if N == 3:
        print("NO")
        return
    print("YES")
    
    if N % 2 == 0:
        A = [1 if i % 2 == 0 else -1 for i in range(N)]
        print(' '.join(map(str, A)))
    else:
        A = [N//2 - 1 if i % 2 == 0 else -(N//2) for i in range(N)]
        print(' '.join(map(str, A)))

for _ in range(int(input())):
    solve()