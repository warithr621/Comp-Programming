n = int(input())
s = input()

l, r = [0 for _ in range(n)], [0 for _ in range(n)]
for i in range(n):
	if s[i] == 'G':
		l[i] = 1
		if i > 0:
			l[i] += l[i-1]
for i in range(n-1, -1, -1):
	if s[i] == 'G':
		r[i] = 1
		if i < n-1:
			r[i] += r[i+1]

ans, cnt = 0, s.count('G')
for i in range(n):
	if s[i] == 'G': continue
	tmp = 1
	if i > 0:
		tmp += l[i-1]
	if i < n-1:
		tmp += r[i+1]
	ans = max(ans, tmp)
ans = min(ans, cnt)
if cnt == n:
	ans = n
print(ans)