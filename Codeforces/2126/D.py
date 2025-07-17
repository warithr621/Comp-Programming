from collections import deque, defaultdict, Counter
from heapq import heappush, heappop

def solve():
    #code
    n, k = map(int, input().split())
    a = []
    for _ in range(n):
        l, r, real = map(int, input().split())
        a.append((l, r, real))
    a.sort(key = lambda x: x[0])
    heap = []
    idx = 0
    while True:
        while idx < n and a[idx][0] <= k:
            l, r, real = a[idx]
            heappush(heap, (-real, r))
            # store all the casinos you can play at from the beginning
            idx += 1
        picked = False
        while heap:
            real, r = heappop(heap)
            real = -real
            if k <= r:
                if real > k:
                    k = real
                    # k <= r means we can play it, but we'll only really play if it helps us
                picked = True
                break
        if not picked:
            break

    print(k)

t = int(input())
for quack in range(t):
    solve()
