# 6 min, why was impl so bad

for _ in range(int(input())):
	n, k, d, w = map(int, input().split())
	t = [0] + [*map(int, input().split())]
	ans = 0
	p = 1
	for i in range(1, n+1):
		if t[i] - t[p] - w > d or i - p + 1 > k:
			p = i
			ans += 1
	print(ans+1)
