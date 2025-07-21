# Problem: https://codeforces.com/contest/1202/problem/A

def solve():
    x = input()[::-1]
    y = input()[::-1]
    py = 0
    while(y[py] != '1'):
        py += 1
    px = py
    while(x[px] != '1'):
        px += 1
    print(px - py)
for _ in range(int(input())):
    solve()
