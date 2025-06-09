n, m = map(int, input().split())
if n > m:
	print(0)
	exit(0)
a = [*map(int, input().split())]
ans = 1
for i in range(n):
	for j in range(i+1, n):
		ans *= abs(a[i] - a[j])
		ans %= m
		if ans == 0:
			break
print(ans)