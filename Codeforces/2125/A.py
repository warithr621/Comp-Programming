import sys
input = sys.stdin.readline

def solve():
	#code
	s = list(input().strip())
	s.sort(reverse=True)
	print(''.join(s))

t = int(input())
for quack in range(t):
	solve()
