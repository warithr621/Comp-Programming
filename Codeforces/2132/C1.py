for _ in range(int(input())):
	n = int(input())
	ans, biggest = 0, 0
	while 3**(biggest+1) <= n:
		biggest += 1
	while n != 0:
		ans += (3**(biggest+1) + biggest * 3**(biggest-1)) * (n // (3**biggest))
		n %= 3**biggest
		biggest -= 1
	print(int(ans))