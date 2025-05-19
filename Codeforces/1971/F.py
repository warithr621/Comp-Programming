for _ in range(int(input())):
	R = int(input())
	# find all lattice points such that r^2 <= x^2 + y^2 < (r+1)^2
	# we can find no. of points such that x >= 0 and y > 0, and then multiply by 4
	ans = 0 # this is point (0, R)
	upperX = R
	for y in range(1, R+1):
		while upperX**2 + y**2 >= (R+1)**2:
			upperX -= 1
		lowX = upperX
		while lowX > 0 and (lowX - 1)**2 + y**2 >= R**2:
			lowX -= 1
		# print(lowX, upperX)
		ans += upperX - lowX + 1
	print(ans << 2)

# for some reason, math approach using isqrt didn't work
# had to look at edi which suggested brute force
# kind of silly i didnt think it would work
# moral of the story: sometimes dumb it down! xd
# um also why does this problem have DFS tag