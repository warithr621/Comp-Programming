n = int(input())
a = [*map(int, input().split())]
ans, vis, cur = 0, set(), 0
vis.add(0)
for i in range(n):
	cur += a[i]
	if cur in vis:
		ans += 1
		vis.clear()
		vis.add(0)
		cur = a[i]
	vis.add(cur)
print(ans)