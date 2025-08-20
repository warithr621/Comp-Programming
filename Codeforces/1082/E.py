from collections import defaultdict
n, c = map(int, input().split())
a = [*map(int, input().split())]

# let f(l, r, x) be the number of times x appears in [l,r]
# we need to find l,r,d that maximizes uhhh f(0, l-1, c) + f(l, r, d) + f(r+1, n-1, c)
# f(0, l-1, c) + f(r+1, n-1, c) = f(0, n-1, c) - f(l, r, c)
# so we really meed to maximize f(0, n-1, c) + (f(l, r, d) - f(l, r, c))
# the first term is fixed lmao
# so we need to find l,r,d that maximizes f(l,r,d) - f(l,r,c)
# ok how to do that
# for a specific d, you can set a[i] = 1 if it is d, a[i] = -1 if it is c, and a[i] = 0 otherwise
# then run Kadane's
# the only issue is that this is still O(N^2),
	# since in the worst case there are N unique elements that each take O(N) Kadane's
# oh wait nvm only the positions of d matter
# like if you have [1, 2, 4, 5, 2, 1, 3, 2] and d = 2
# if you have an array not bounded by d's, you could shrink it and never make it worse

p = [0 for _ in range(n+1)]
for i in range(1, n+1):
	p[i] = p[i-1] + (a[i-1] == c)
pos = defaultdict(list)
for i in range(n):
	pos[a[i]].append(i)

ans = -1
for d in pos:
	if d == c:
		continue
	cur, best = 0, -1
	arr = pos[d]
	for i in range(len(arr)):
		val = 1
		cur = max(val, cur + val)
		best = max(best, cur)
		if i + 1 < len(arr):
			l, r = arr[i], arr[i + 1]
			gap = p[r+1] - p[l]
			cur = max(-gap, cur - gap)
			best = max(best, cur)
	ans = max(ans, best)

print(p[n] + max(ans, 0))