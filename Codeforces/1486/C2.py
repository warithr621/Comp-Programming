def query(l, r):
	print(f"? {l} {r}", flush=True)
	return int(input())
def answer(p):
	print(f"! {p}", flush=True)

n = int(input())
second_max = query(1, n)
if second_max == n or query(second_max, n) != second_max:
	# query(1, second_max) is going to return second_max
	# find the biggest M where query(M, second_max) is second_max
	L, R = 1, second_max - 1
	while L < R:
		M = (L + R + 1) // 2
		q = query(M, second_max)
		if q == second_max:
			L = M
		else:
			R = M - 1
	answer(L)
else:
	# we know query(second_max, n) is going to return second_max
	# find the smallest M where query(second_max, M) is second_max
	L, R = second_max + 1, n
	while L < R:
		M = (L + R) // 2
		q = query(second_max, M)
		if q == second_max:
			R = M
		else:
			L = M + 1
	answer(L)