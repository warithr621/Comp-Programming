def solve():
	#code
	n = int(input())
	a = [*map(int, input().split())]
	a.sort(reverse=True)
	works = True
	for i in range(2, n):
		if a[i-2] % a[i-1] != a[i]:
			works = False
	if works:
		print(a[0], a[1])
	else:
		print(-1)

t = int(input())
for quack in range(t):
	solve()