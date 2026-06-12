from collections import deque

def solve():
	#code
	n = int(input())
	a = [* map(int, input().split())]
	ans = 0
	for L in range(1, n//2+1):
		m = n - L + 1
		good = [0] * m
		freq = [0] * (n+1)
		distinct = 0
		mindq, maxdq = deque(), deque()
		for i in range(L):
			x = a[i]
			if freq[x] == 0:
				distinct += 1
			freq[x] += 1

			while mindq and mindq[-1][0] > x:
				mindq.pop()
			mindq.append((x,i))
			while maxdq and maxdq[-1][0] < x:
				maxdq.pop()
			maxdq.append((x,i))

		for s in range(m):
			while mindq and mindq[0][1] < s:
				mindq.popleft()
			while maxdq and maxdq[0][1] < s:
				maxdq.popleft()

			mn = mindq[0][0]
			mx = maxdq[0][0]
			if distinct == L and mx - mn == L - 1:
				good[s] = mn
			if s + L < n:
				out = a[s]
				freq[out] -= 1
				if freq[out] == 0:
					distinct -= 1
				inn = a[s + L]
				if freq[inn] == 0:
					distinct += 1
				freq[inn] += 1

				while mindq and mindq[-1][0] > inn:
					mindq.pop()
				mindq.append((inn, s + L))
				while maxdq and maxdq[-1][0] < inn:
					maxdq.pop()
				maxdq.append((inn, s + L))

		seen = [False] * (n+2)
		ok = False
		for s in range(m):
			if s - L >= 0 and good[s - L]:
				seen[good[s - L]] = True
			x = good[s]
			if x:
				if (x - L >= 1 and seen[x - L]) or (x + L <= n and seen[x + L]):
					ok = True
					break
		if ok:
			ans = L

	print(ans)


t = int(input())
for quack in range(t):
	solve()
