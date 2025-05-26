def solve():
    #code
    n, k = map(int, input().split())
    s = input()
    z, o = s.count('0'), s.count('1')
    if z//2 + o//2 < k:
        print("NO")
        return
    z -= (n-2*k)//2
    o -= (n-2*k)//2
    print("YES" if z >= 0 and o >= 0 and z % 2 == 0 and o % 2 == 0 else "NO")

t = 1
t = int(input())
for quack in range(t):
    solve()