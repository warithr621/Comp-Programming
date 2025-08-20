import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write

for _ in range(int(input())):
	n, q = map(int, input().split())
	a = list(map(int, input().split()))
	pfx = [0] * (n+1)
	for i in range(1, n+1):
		pfx[i] = pfx[i-1] + a[i-1]
	def query(c, l, r):
		# returns the sum of elements in the interval [l,r] of the cth cyclic shift
		l, r = (l+c)%n, (r+c)%n
		if l <= r:
			return pfx[r+1] - pfx[l]
		else:
			return (pfx[n] - pfx[l]) + pfx[r+1]
	for i in range(q):
		l, r = map(int, input().split())
		l, r = l-1, r-1 # i like 0 indexing :>
		cl, cr = l//n, r//n
		ans = 0
		if cl == cr:
			ans = query(cl, l%n, r%n)
		else:
			# the number of whole shifts between them is cr - cl - 1
			whole = cr - cl - 1
			ans = (whole * pfx[n]) + query(cl, l%n, n-1) + query(cr, 0, r%n)
		write(str(ans) + '\n')