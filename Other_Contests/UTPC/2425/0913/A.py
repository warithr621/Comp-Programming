N = int(input())
X, Y = map(int, input().split())
best, dist = [0,1e18], 1e18
for i in range(N):
    a, b = map(int, input().split())
    # print(a, b, (X-a)**2 + (Y-b)**2)
    if dist >= (X-a)**2 + (Y-b)**2:
        if dist == (X-a)**2 + (Y-b)**2:
            if a < best[0]:
                best = [a,b]
            elif a == best[0] and b < best[1]:
                best = [a,b]
        else:
            best = [a,b]
        dist = (X-a)**2 + (Y-b)**2
print(best[0], best[1])