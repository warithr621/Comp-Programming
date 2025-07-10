# start: 12:28
# end  : 12:35 <-- washed skull too much thinking

for _ in range(int(input())):
	x, y, k = map(int, input().split())
	# as soon as it gets to 1, it's just looping 1, 2, ..., k-1, 1, etc.
	while k > 0 and x != 1:
		delta = (x//y+1) * y - x
		delta = min(max(1, delta), k)
		x += delta
		while x % y == 0:
			x //= y
		k -= delta

	print(x + k % (y-1))