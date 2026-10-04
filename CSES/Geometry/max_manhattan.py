n = int(input())

# holy chebyshev
minU, maxU, minV, maxV = float('inf'), float('-inf'), float('inf'), float('-inf')
for _ in range(n):
	x, y = map(int, input().split())
	u, v = x + y, x - y
	minU, maxU = min(minU, u), max(maxU, u)
	minV, maxV = min(minV, v), max(maxV, v)
	print(max(maxU - minU, maxV - minV))
