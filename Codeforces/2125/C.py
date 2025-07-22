import sys
input = sys.stdin.readline

def cnt(l, r, p):
	left = (l + p - 1) // p * p
	right = r // p * p
	return (right - left) // p + 1

def solve():
	#code
	l, r = map(int, input().split())
	x = r - l + 1
	x = x - cnt(l,r,2) - cnt(l,r,3) - cnt(l,r,5) - cnt(l,r,7) + cnt(l,r,6) + cnt(l,r,10) + cnt(l,r,14) + cnt(l,r,15) + cnt(l,r,21) + cnt(l,r,35) - cnt(l,r,30) - cnt(l,r,42) - cnt(l,r,70) - cnt(l,r,105) + cnt(l,r,210)
	print(x)

t = int(input())
for quack in range(t):
	solve()
