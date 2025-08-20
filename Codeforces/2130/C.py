def solve():
	# code
	n = int(input())
	segments = [tuple(map(int, input().split())) for _ in range(n)]
	segs = [(r-l, l, r, i+1) for i,(l,r) in enumerate(segments)]
	segs.sort(reverse=True) # sort by length

	cover, ans = [], []

	def magic(l, r):
		i = bisect_left(cover, (l,-1))
		if i > 0:
			i -= 1
		gain, cur = 0, l
		while i < len(cover) and cover[i][0] <= r:
			s, e = cover[i]
			if e <= cur:
				i += 1
				continue
			if s > cur:
				gain += s - cur
			cur = max(cur, e)
			i += 1
		if cur < r:
			gain += r - cur
		return gain

	def merge(l, r):
		i = bisect_left(cover, (l,-1))
		if i > 0:
			i -= 1
		s, e = l, r
		reml, remr = None, None
		j = i
		while j < len(cover) and cover[j][0] < r:
			s0, e0 = cover[j]
			if e0 <= l:
				j += 1
				continue
			if reml is None:
				reml = j
				s = min(s, s0)
			e = max(e, e0)
			j += 1
		if reml is not None:
			remr = j
			del cover[reml:remr]
			insort(cover, (s, e))
		else:
			insort(cover, (l, r))

	for length, l, r, idx in segs:
		g = magic(l, r)
		if g > 0:
			merge(l, r)
			ans.append(idx)

	ans.sort()
	print(len(ans))
	print(*ans)


t = int(input())
for quack in range(t):
	solve()