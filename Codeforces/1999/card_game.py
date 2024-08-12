# https://codeforces.com/contest/1999/problem/B

def win(a, b, c, d):
    alpha, beta = 0, 0
    if a > c:
        alpha += 1
    elif c > a:
        beta += 1
    if b > d:
        alpha += 1
    elif b < d:
        beta += 1
    return alpha > beta

for _ in range(int(input())):
    a, b, c, d = map(int, input().split())
    ans = 2 * win(a, b, c, d) + 2 * win(b, a, c, d)
    print(ans)