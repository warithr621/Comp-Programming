n, m = map(int, input().split())
a = [[0]]
for _ in range(m):
	a.append([0] + list(map(int, input().split())))

b = [0] * (n + 1)
for i in range(1, n+1):
	b[a[1][i]] = i
for i in range(1, m+1):
	for j in range(1, n+1):
		a[i][j] = b[a[i][j]]

# print('\n'.join(map(str, a)))
mn = [n for i in range(n+1)]
for i in range(1, m+1):
	cur = 1
	for j in range(1, n+1):
		if cur < j:
			cur += 1
		while cur < n and a[i][cur+1] == a[i][cur] + 1:
			cur += 1
		mn[a[i][j]] = min(mn[a[i][j]], a[i][cur])

ans, cur = 0, 1
while cur <= n:
	banana = mn[cur] - cur + 1
	ans += banana * (banana + 1) // 2
	cur = mn[cur] + 1
print(ans)