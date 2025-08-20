def in_li(num=True):
	return [*map(int if num else str, input().split())]

def check(big, k):
	n = len(big) - 1
	pfx = [0] * (n+1)
	for i in range(1, n+1):
		pfx[i] = pfx[i-1] + big[i]
	best, pos = 0, 0
	for i in range(k, n+1):
		if pfx[i-k] < best:
			best, pos = pfx[i-k], i-k
		if pfx[i] >= best:
			return pos+1, i
	return None

def solve():
	#code
	n, k = map(int, input().split())
	a = in_li()
	# to clarify, a number is a median of an array A (assume sorted) if
		# len(A) is even: in the range [A[n//2-1], A[n//2]]
		# len(A) is odd: A[n//2] is the only solution
	# i think "is v a submedian" is monotonic?? gotta check later
	L, R = min(a), max(a)
	ans = [L, 1, k]
	while L <= R:
		M = (L + R) // 2
		big = [0] * (n+1)
		for i in range(1, n+1):
			big[i] = 1 if a[i-1] >= M else -1
		if (res := check(big, k)): # WALRUS OPERATOR GUIDE ME
			ans = [M, res[0], res[1]]
			L = M+1
		else:
			R = M-1
	print(*ans)

t = int(input())
for quack in range(t):
	solve()
