for _ in range(int(input())):
	n, m = map(int, input().split())
	a = [*map(int, input().split())]
	k = int(input())
	b = [*map(int, input().split())]
	# expand
	def expand(arr):
		ret = []
		for x in arr:
			cnt, val = 1, x
			while val % m == 0:
				cnt *= m
				val //= m
			if len(ret) != 0 and ret[-1][0] == val:
				ret[-1][1] += cnt
			else:
				ret.append([val, cnt])
		return ret
	# print(expand(a))
	# print(expand(b))
	print("Yes" if expand(a) == expand(b) else "No")