for _ in range(int(input())):
	n = int(input())
	ans = [-1, 3] * (n//2)
	if n % 2 == 1:
		ans.append(-1)
	else:
		ans[-1] = 2
	print(*ans)