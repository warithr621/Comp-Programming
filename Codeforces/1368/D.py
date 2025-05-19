N = int(input())
A = [*map(int, input().split())]

# tl;dr choose two values a_i = X and a_j = Y
# then set a_i = X & Y, and a_j = X | Y
# maximize the sum of squares

# take advantage of the fact that X & Y <= min(X, Y)
# and that X | Y >= max(X, Y)
# another thing to note: X + Y = (X&Y) + (X|Y)
# letting x <= y, we can say (X & Y) = X - D, and (X | Y) = Y + D
# thus, an operation changes our total sum from X^2 + Y^2 to (X - D)^2 + (Y + D)^2
# or an increase of 2D(Y - X + D), where D >= 0 is always true
# thus as long as we change the numbers, it'll help us
# also note it's better to have a few big numbers than several medium numbers, probably
# also also if you have two numbers X and Y,
	# where for a particular bit X has the bit and Y doesn't, doing the op will 
	# keep only one of the numbers with the bit, so you want the larger one to have it

# wow I made a lot of notes, time for actual coding
# also had to peek at edi for this
	# because I didn't know about the "X + Y = (X&Y) + (X|Y)", which was kinda helpful

bitcount = [0 for _ in range(20)]
for bit in range(20):
	for x in A:
		if (x & (1 << bit)) != 0:
			bitcount[bit] += 1
reconstructed = [0 for _ in range(N)]
for bit in range(20):
	for i in range(bitcount[bit]):
		reconstructed[i] |= (1 << bit)
ans = 0
for x in reconstructed:
	ans += x * x
print(ans)