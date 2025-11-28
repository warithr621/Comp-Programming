for _ in range(int(input())):
	n = int(input())
	a = [0] + [*map(int, input().split())] # 1-index a
	pfx = [0] * (n + 1)
	for i in range(1, n + 1):
		pfx[i] = pfx[i - 1] + a[i]
	# recall sum(i, j) = pfx[j] - pfx[i - 1], where i,j are 1-indexed
	# the new sum is (l+r) * (r - l + 1)
	# so we want to maximize (l + r) * (r - l + 1) - (pfx[r] - pfx[l - 1])
	# for some l,r
	# this is equal to (-l^2 + l + r^2 + r) - pfx[r] + pfx[l-1]
	# so let f(x) = x^2 + x - pfx[x], this is just f(r) - f(l-1) i think
	mn, ans = 0, 0
	for i in range(1, n+1):
		cur = i * i + i - pfx[i]
		mn = min(mn, cur)
		ans = max(ans, cur - mn)
	print(pfx[n] + ans)