def solve():
	#code
	n = int(input())
	# a + b = n, a is palindrome, b divis by 12
	# ????
	# a = n (mod 12), which eliminates b
	# does such a palindrome exist?
	if n == 10:
		print(-1)
		return
	a = n % 12
	if a == 10:
		a = 22
	print(a, n-a)
	
t = int(input())
for quack in range(t):
	solve()