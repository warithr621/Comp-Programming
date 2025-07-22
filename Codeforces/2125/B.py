import sys
import math
input = sys.stdin.readline

def solve():
	#code
	a, b, k = map(int, input().split())
	g = math.gcd(a,b)
	a, b = a//g, b//g
	print(1 if 0 <= a <= k and 0 <= b <= k else 2)

t = int(input())
for quack in range(t):
	solve()
