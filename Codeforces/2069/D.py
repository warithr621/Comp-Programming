import sys, os, io
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write

def manacher(s):
	n = len(s)
	d1 = [0] * n
	l, r = 0, -1
	for i in range(n):
		k = 1 if i > r else min(d1[l+r-i], r-i+1)
		while i-k >= 0 and i+k < n and s[i-k] == s[i+k]:
			k += 1
		d1[i] = k
		if i + k - 1 > r:
			l = i - k + 1
			r = i + k - 1

	d2 = [0] * n
	l, r = 0, -1
	for i in range(n):
		k = 0 if i > r else min(d2[l+r-i+1], r-i+1)
		while i-k-1 >= 0 and i+k < n and s[i-k-1] == s[i+k]:
			k += 1
		d2[i] = k
		if i + k - 1 > r:
			l = i - k
			r = i + k - 1
	return d1, d2

def palindrome(d1, d2, l, r):
	length = r - l
	if length <= 1:
		return True
	if length & 1:
		center = l + (length // 2)
		need = (length // 2) + 1
		return d1[center] >= need
	else:
		center = l + (length // 2)
		need = (length // 2)
		return d2[center] >= need

def solve(S):
	n = len(S)
	pref = [[0]*26 for _ in range(n+1)]
	for i,ch in enumerate(S):
		c = ord(ch) - 97
		row = pref[i+1]
		prev = pref[i]
		row[:] = prev[:]
		row[c] += 1
	d1, d2 = manacher(S)

	L, R = 2, n
	while L < R:
		M = (L + R) // 2
		if M <= n // 2:
			ok = True
			for i in range(26):
				if pref[M][i] != pref[n][i] - pref[n-M][i]:
					ok = False
					break
			if ok and palindrome(d1, d2, M, n-M):
				R = M
			else:
				L = M + 1
		else:
			works = True
			for i in range(26):
				x = 2*pref[M][i] - pref[n][i]
				if x < 0 or (x & 1):
					works = False
					break
			if works:
				R = M
			else:
				L = M + 1
	return L

t = int(input().strip() or 0)
for _ in range(t):
	s = input().strip().decode()
	if not s:
		write("0\n")
		continue
	i, j = 0, len(s)-1
	while i < j and s[i] == s[j]:
		i += 1; j -= 1
	if i >= j:
		write("0\n")
		continue
	S = s[i:j+1]
	ans = min(solve(S), solve(S[::-1]))
	write(str(ans) + "\n")
