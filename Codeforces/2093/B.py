def solve():
    # code
    n = input()
    ans = 0
    while len(n) != 0 and n[-1] == '0':
        n = n[:-1]
        ans += 1
    print(ans + len(n.replace('0', '')) - 1)

t = int(input())
for quack in range(t):
    solve()