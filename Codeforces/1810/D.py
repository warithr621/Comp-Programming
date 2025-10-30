def find_days(a, b, height):
	if height <= a:
		return 1
	return 1 + (height - b - 1) // (a - b)

def find_range(a, b, n):
	mx = (n-1) * (a-b) + a
	mn = 1 if n == 1 else (n-1) * (a-b) + (b + 1)
	return (mn, mx)

for _ in range(int(input())):
	q = int(input())
	height = (1, int(2e18))
	ans = []
	for query in range(q):
		arr = [*map(int, input().split())]
		if arr[0] == 1:
			a, b, n = arr[1:]
			reduction = find_range(a, b, n)
			if reduction[0] > height[1] or reduction[1] < height[0]:
				ans.append(0)
			else:
				height = (max(reduction[0], height[0]), min(reduction[1], height[1]))
				ans.append(1)
		else:
			a, b = arr[1:]
			mn, mx = find_days(a, b, height[0]), find_days(a, b, height[1])
			if mn != mx:
				ans.append(-1)
			else:
				ans.append(mx)
	print(' '.join(map(str, ans)))