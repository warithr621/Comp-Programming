n, s = map(int, input().split())
low, high = s, s
for _ in range(n):
	l, r = map(int, input().split())
	test_low = max(low, l) + 1
	test_high = min(high, r) + 1
	if test_low <= test_high:
		low = min(test_low, low)
		high = max(test_high, high)
print(high)