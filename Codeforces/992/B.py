from math import gcd

l, r, x, y = map(int, input().split())
# if gcd(a, b) = x and lcm(a, b) = y, then a * b = x * y
n = x * y
ans = 0
f = x
while f * f <= n:
	if n % f == 0:
		if l <= f <= r and l <= n//f <= r and gcd(f, n//f) == x:
			ans += 1
			if f * f != n:
				ans += 1
	f += x
print(ans)