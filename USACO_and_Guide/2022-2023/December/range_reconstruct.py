# 2022 Dec Silver P3

N = int(input())
diff = [list(map(int, input().split())) for _ in range(N)]
ans = [0] * N

for i in range(N-2, -1, -1):
	ans[i] = ans[i+1] + diff[i][1]

	b = True
	mx, mn = -1e10, 1e10
	for j in range(i, N):
		mx = max(mx, ans[j])
		mn = min(mn, ans[j])
		b &= (mx - mn == diff[i][j-i])

	if not b:
		ans[i] -= 2 * diff[i][1]

print(' '.join(map(str, ans)))