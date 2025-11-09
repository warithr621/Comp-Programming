for _ in range(int(input())):
	h, w, xa, ya, xb, yb = map(int, input().split())
	if xa % 2 == xb % 2:
		ans = "Bob"
		if xa >= xb:
			draw = True
		elif ya == yb:
			draw = False
		else:
			turns = (yb - 1) if ya < yb else (w - yb)
			draw = xb - 2 * turns < xa
	else:
		ans = "Alice"
		xa += 1
		ya += 0 if ya == yb else 1 if yb > ya else -1
		if xa > xb:
			draw = True
		elif ya == yb:
			draw = False
		else:
			turns = (w - ya) if ya < yb else (ya - 1)
			draw = xb - 2 * turns < xa
	print('Draw' if draw else ans)