n, s = map(int, input().split())
if s >= 2*n:
	print("YES")
	ans = ([2] * (n-1)) + [s - 2*(n-1)]
	print(*ans)
	print(1)
else:
	print("NO")