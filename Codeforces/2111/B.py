fib = [1, 2, 3, 5, 8, 13, 21, 34, 55, 89]

def solve():
	#code
	n, m = map(int, input().split())
	for _ in range(m):
		w, l, h = map(int, input().split())
		empty = [(w, l, h)]
		ans = '1'
		for i in range(n-1, -1, -1):
			sz = fib[i]
			works = -1
			for idx, (W,L,H) in enumerate(empty):
				if W >= sz and L >= sz and H >= sz:
					works = idx
					break
			if works < 0:
				ans = '0'
				break
			W, L, H = empty.pop(works)
			aw, al, ah = W - sz, sz, sz
			if aw > 0 and al > 0 and ah > 0:
				empty.append((aw, al, ah))
			bw, bl, bh = W, L - sz, sz
			if bw > 0 and bl > 0 and bh > 0:
				empty.append((bw, bl, bh))
			cw, ch, ch = W, L, H - sz
			if cw > 0 and ch > 0 and ch > 0:
				empty.append((cw, ch, ch))
		print(ans,end='')
	print()



t = int(input())
for quack in range(t):
	solve()