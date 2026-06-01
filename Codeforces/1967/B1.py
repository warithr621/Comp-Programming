for _ in range(int(input())):
	n, m = map(int, input().split())
	# find no. of pairs s.t. b * gcd(a,b) divides a+b
	# b | a must be true, so a = kb for integer k
	# find no. of pairs (a,k) such that
		# 1 <= k <= n/b
		# 1 <= b <= m
		# k+1 is a multiple of b -> qb - 1 = k
	# number of value q is floor((n+b)/b^2) i think
	ans = 0
	for b in range(1, m+1):
		val = (n + b) // b**2
		if val == 0:
			break
		ans += val
	print(ans - 1) # -1 bcz of the (0,1) case this counts