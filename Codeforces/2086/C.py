import math
MOD = int(1e9+7)

class DSU:
    def __init__(self, n):
        self.parent = list(range(n+1))
        self.size = [1] * (n+1)

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unite(self, x, y):
        rx, ry = self.find(x), self.find(y)
        if rx != ry:
            if self.size[rx] < self.size[ry]:
                rx, ry = ry, rx
            self.parent[ry] = rx
            self.size[rx] += self.size[ry]

    def get_size(self, x):
        return self.size[self.find(x)]

def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n = int(input())
    p = in_li()
    d = in_li()
    dsu = DSU(n)
    for i in range(n):
        dsu.unite(i+1, p[i])
    flagged, ans = set(), 0
    for query in d:
        root = dsu.find(p[query - 1])
        if root not in flagged:
            flagged.add(root)
            ans += dsu.get_size(root)
        print(ans, end=' ')
    print()

t = int(input())
for quack in range(t):
    solve()