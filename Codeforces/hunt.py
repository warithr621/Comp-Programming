#Problem: https://codeforces.com/contest/807/problem/B

p, x, y = map(int, input().split())
def check(s):
    i = (s // 50) % 475
    for t in range(25):
        i = (i * 96 + 42) % 475
        if 26 + i == p:
            return True
    return False

for up in range(500):
    for down in range(500):
        if x + 100 * up - 50 * down >= y and check(x + 100 * up - 50 * down):
            print(up)
            exit()
