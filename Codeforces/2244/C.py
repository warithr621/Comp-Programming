from math import gcd

for _ in range(int(input())):
	n, x, y = map(int, input().split())
	p = [*map(int, input().split())]
	g = gcd(x, y)
	if any((i+1) % g != p[i] % g for i in range(n)):
		print("NO")
	else:
		print("YES")