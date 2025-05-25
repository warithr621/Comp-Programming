def f(n):
	if (n & (n-1)) == 0:
		return n
	cnt = 0
	while n != 0:
		n >>= 1
		cnt += 1
	return 1 << cnt

for _ in range(int(input())):
	# find K such that (x + K) + (y + K) = (x + K) xor (y + K)
	# what must be true if A + B = A xor B?
	# note that A + B = (A xor B) + 2 * (A and B)
	# therefore, A and B must be 0
	# if x = y originally, then obviously (x + K) and (x + K) is always nonzero
	# what if x != y
	# let x >= y, and we say V = 2 * (smallest power of 2 that is at least x)
	# then we say K = V - x
	# then x + K = V, y + K = (y-x) + V
	# since y-x < 0, it should work
	x, y = map(int, input().split())
	if x == y:
		print(-1)
		continue
	if x < y:
		x, y = y, x
	print((f(x) << 1) - x)