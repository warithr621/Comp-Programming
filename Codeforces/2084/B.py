import math

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    a.sort()
    g = 0
    for i in range(1, n):
        if a[i] % a[0] == 0:
            if g == 0:
                g = a[i]
            g = math.gcd(g, a[i])
    print("Yes" if g == a[0] else "No")