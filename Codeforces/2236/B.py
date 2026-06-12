def solve():
	#code
	n, k = map(int, input().split())
	s = [c for c in input()]
	for i in range(n-k):
		if s[i] == '1':
			s[i] = '0'
			if s[i+k] == '0':
				s[i+k] = '1'
			else:
				s[i+k] = '0'
	if '1' in s:
		print("NO")
	else:
		print("YES")

t = int(input())
for quack in range(t):
	solve()
