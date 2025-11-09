for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	
	ans = sum(abs(x) for x in a)
	S = sum(abs(x - (-1)) for x in a)
	if n == 1:
		ans = min(ans, abs(a[0] - a[1]))
	if n == 2:
		ans = min(ans, abs(a[0]-2) + abs(a[1]-2) + abs(a[2]-2) + abs(a[3]-2))
	if n % 2 == 0:
		for i in range(2*n):
			ans = min(ans, S - abs(a[i] - (-1)) + abs(a[i] - n))
	print(ans)