from collections import defaultdict

n, m = map(int, input().split())
s, r = [], []
for _ in range(n):
	si, ri = map(int, input().split())
	s.append(si)
	r.append(ri)

d = defaultdict(list)
for i in range(n):
	d[s[i]].append(r[i])

mx = 0
for subject in d:
	d[subject].sort(reverse=True)
	mx = max(mx, len(d[subject]))

ans = [0 for _ in range(mx+1)]
for subject in d:
	p = 0
	for i, v in enumerate(d[subject], start=1):
		p += v
		if p > 0:
			ans[i] += p
		else:
			break

print(max(ans))