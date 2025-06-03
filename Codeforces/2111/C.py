def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	#code
	n = int(input())
	a = in_li()
	ans = float('inf')
	left, right = 0, 0
	while left < n and right < n:
		while right + 1 < n and a[right+1] == a[left]:
			right += 1
		alt = a[left] * (left + n - right - 1)
		ans = min(ans, alt)
		# print(left,right)
		left, right = right+1, right+1
	print(ans)



t = int(input())
for quack in range(t):
	solve()