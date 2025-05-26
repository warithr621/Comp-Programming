import sys
input = sys.stdin.readline
from collections import Counter # wow I might have brute forced this

def solve():
    n = int(input())
    pts = [None] * n
    xs = []
    ys = []
    for i in range(n):
        x, y = map(int, input().split())
        pts[i] = (x, y)
        xs.append(x)
        ys.append(y)

    if n <= 2:
        print(n)
        return

    xs.sort()
    ys.sort()
    cnt_x = Counter(xs)
    cnt_y = Counter(ys)
    orig_min_x = xs[0]
    orig_max_x = xs[-1]
    orig_min_y = ys[0]
    orig_max_y = ys[-1]

    orig_width = orig_max_x - orig_min_x + 1
    orig_height = orig_max_y - orig_min_y + 1
    ans = orig_width * orig_height

    candidates = set()
    for i, (x, y) in enumerate(pts):
        if (x == orig_min_x and cnt_x[orig_min_x] == 1) or \
           (x == orig_max_x and cnt_x[orig_max_x] == 1) or \
           (y == orig_min_y and cnt_y[orig_min_y] == 1) or \
           (y == orig_max_y and cnt_y[orig_max_y] == 1):
            candidates.add(i)

    ux = sorted(cnt_x.keys())
    uy = sorted(cnt_y.keys())

    for i in candidates:
        x_i, y_i = pts[i]

        if x_i == orig_min_x and cnt_x[orig_min_x] == 1:
            new_min_x = ux[1]
        else:
            new_min_x = orig_min_x

        if x_i == orig_max_x and cnt_x[orig_max_x] == 1:
            new_max_x = ux[-2]
        else:
            new_max_x = orig_max_x

        if y_i == orig_min_y and cnt_y[orig_min_y] == 1:
            new_min_y = uy[1]
        else:
            new_min_y = orig_min_y

        if y_i == orig_max_y and cnt_y[orig_max_y] == 1:
            new_max_y = uy[-2]
        else:
            new_max_y = orig_max_y

        new_width  = new_max_x - new_min_x + 1
        new_height = new_max_y - new_min_y + 1
        area = new_width * new_height

        if area > (n - 1):
            ans = min(ans, area)
        else:
            expand1 = (new_width + 1) * new_height
            expand2 = new_width * (new_height + 1)
            ans = min(ans, expand1, expand2)

    print(ans)

t = 1
t = int(input())
for quack in range(t):
    solve()