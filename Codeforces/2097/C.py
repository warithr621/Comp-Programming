from math import gcd

def extended_gcd(a, b):
	if a == 0:
		return b, 0, 1
	gcd, x1, y1 = extended_gcd(b % a, a)
	x = y1 - (b // a) * x1
	y = x1
	return gcd, x, y

def modular_inverse(a, m):
	gcd, x, _ = extended_gcd(a, m)
	if gcd != 1:
		return -1
	return x % m

def solve(x, vx, n):
	g = gcd(vx, n)
	if x % g != 0:
		return (None, None)
	vxg, ng, xg = vx // g, n // g, x // g
	inv = modular_inverse(vxg % ng, ng)
	return (inv * (-xg) % ng, ng)

def crt(a, m, b, t):
	# find k s.t. k = a (mod m) and b (mod t)
	g = gcd(m, t)
	if (a-b) % g != 0:
		return (None, None)
	_, u, v = extended_gcd(m, t)
	lcm = m // g * t
	diff = (b-a) // g
	shift = (diff * u) % (t // g)
	return ((a + m * shift) % lcm, lcm)

for _ in range(int(input())):
	n, x, y, vx, vy = map(int, input().split())
	g = gcd(vx, vy)
	vx, vy = vx // g, vy // g
	# basically draw a line that hopefully reaches (tx, ty)
	# where tx = 0 (mod n) and ty = 0 (mod n)
	# tx = x + k * vx, ty = y + k * vy
	# x + k * vx = 0 (mod n), y + k * vy = 0 (mod n)
	# find minimum positive k that satisfies this, if it exists
	def magic():
		a, m = solve(x, vx, n)
		b, t = solve(y, vy, n)
		if a is None or b is None:
			return -1
		k, mod = crt(a, m, b, t)
		if k is None or k == 0:
			return mod if k == 0 else None
		return k
	k = magic()
	if k is None or k == -1:
		print(-1)
		continue
	tx, ty = (x + k * vx)//n, (y + k * vy)//n
	print((tx-1) + (ty-1) + (tx+ty)//2 + abs(tx-ty)//2)
