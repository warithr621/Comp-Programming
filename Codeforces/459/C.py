n, k, d = map(int, input().split())
tmp = 1
antisus = False
for i in range(d):
	tmp *= k
	if tmp >= n:
		antisus = True
		break
if not antisus:
	print(-1)
	exit()

# print the first N d-digit numbers in base K
ans = [[0 for _ in range(n)] for _ in range(n)]
for i in range(1, n):
	for j in range(d):
		ans[i][j] = ans[i-1][j]
	for j in range(d-1, -1, -1):
		ans[i][j] = (ans[i][j] + 1) % k
		if ans[i][j] > 0:
			break
# print('\n'.join(map(str, ans)))
for i in range(d):
	for j in range(n):
		print(ans[j][i] + 1, end=' ')
	print()
