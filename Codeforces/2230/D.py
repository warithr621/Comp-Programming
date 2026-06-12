for _ in range(int(input())):
	#code
	n = int(input())
	a = [*map(int, input().split())]; a = [x-1 for x in a]
	b = [*map(int, input().split())]; b = [x-1 for x in b]
	# if [L, R] works, then clearly [L, R-1] works
	# so for each L, we need to find the latest R that works
	# probably make dp[L] = the latest R that works for L and iterate backwards?
	dp, ia, ib = ([n] * (n+1) for _ in range(3))
	ans = 0
	for i in range(n-1, -1, -1):
		ia[a[i]] = i
		ib[b[i]] = i
		if a[i] == b[i]: # gonna watch episode a[i] on same day
			x = a[i] + 1
			if ia[x] == ib[x]:
				dp[i] = dp[ia[x]] # same ans as when you watch a[i]+1
			else:
				dp[i] = min(ia[x], ib[x])
		# change ans depending on when ep 1 happens
		if ia[0] != ib[0]:
			ans += min(ia[0], ib[0]) - i
		else:
			ans += dp[ia[0]] - i
	print(ans)