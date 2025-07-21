for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    # we can always partition a into a bunch of 1-size subarrs
    # can we make a 2-size subarr?
    works = False
    for i in range(n-1):
        u, v = a[i], a[i+1]
        works |= (2 * u > v and 2 * v > u)
    print("YES" if works else "NO")