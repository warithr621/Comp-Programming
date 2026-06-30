def solve():
	#code
	n = int(input())
	s = input()
	if '0' not in s or '1' not in s:
		print(1)
	elif '01' in s and '10' in s:
		print(1)
	else:
		print(2)

t = int(input())
for quack in range(t):
	solve()
