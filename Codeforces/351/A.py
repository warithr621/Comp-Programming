from math import floor, ceil
import sys
input = sys.stdin.readline
write = sys.stdout.write

n = int(input())
a = [*map(float, input().split())]
up = [ceil(x)-x for x in a]
down = [floor(x)-x for x in a]

base = sum(down)
doubles = sum(1 for x in a if abs(x - round(x)) > 1e-9)
ints = 2 * n - doubles
l, r = max(0, n - ints), min(n, doubles)
ans = min(abs(base + k) for k in range(l, r+1))
write(f"{ans:.3f}\n")