def solve():
	#code
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	a.sort()
	vals, cnt = [], []
	for x in a:
		if not vals or x != vals[-1]:
			vals.append(x)
			cnt.append(1)
		else:
			cnt[-1] += 1
	m = len(vals)
	l, cur, ans = 0, 0, 0
	for r in range(m):
		if r > 0 and vals[r] - vals[r-1] > 1:
			l = r
			cur = cnt[r]
		else:
			cur += cnt[r]
			while (r - l + 1) > k:
				cur -= cnt[l]
				l += 1
		ans = max(cur, ans)
	print(ans)

t = int(input())
for quack in range(t):
	solve()
