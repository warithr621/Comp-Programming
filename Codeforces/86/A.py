def reflection(n):
	s = str(n)
	t = ""
	for c in s:
		d = ord(c) - ord('0')
		t += chr(ord('0') + (9-d))
	return int(t)

def weight(n):
	return n * reflection(n)

l, r = map(int, input().split())
ans = [weight(l), weight(r)] + [weight(5 * 10**i) if l <= 5 * 10**i <= r else -1 for i in range(10)]
print(max(ans))