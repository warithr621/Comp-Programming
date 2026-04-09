def skib(n):
	if n == 1:
		return 1
	f = []
	p = 2
	while p * p <= n:
		if n % p == 0:
			while n % p == 0:
				n //= p
			f.append(p)
		p += 1
	if n != 1:
		f.append(n)
	if len(f) >= 2:
		return 0
	else:
		return f[0]

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	b = [skib(x) for x in a]
	if (a == sorted(a)) or ((0 not in b) and (b == sorted(b))):
		print("Bob")
	else:
		print("Alice")