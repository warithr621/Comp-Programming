def prime(x):
    if x <= 1: return False
    if x <= 3: return True
    p = 2
    while p * p <= x:
        if x % p == 0: return False
        p += 1
    return True

def solve():
    # code
    n, k = map(int, input().split())
    if n == 1 and k == 2:
        print("YES")
        return
    if n == 1 or k > 1:
        print("NO")
        return
    print("YES" if prime(n) else "NO")

t = int(input())
for quack in range(t):
    solve()