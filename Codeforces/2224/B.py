for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	hawk, tuah = 0, 0 # max and mex
	seen = [False] * (len(a) + 1)
	for x in a:
		hawk = max(hawk, x)
		if x <= len(a):
			seen[x] = True
		while tuah <= len(a) and seen[tuah]:
			tuah += 1
	ans = hawk * n
	if hawk >= tuah:
		ans += tuah * (tuah-1) // 2 + tuah * (n - tuah)
	else:
		ans += tuah * (tuah + 1) // 2 + tuah * (n - tuah) - hawk # have to subtract max b/c of jump
	print(ans)