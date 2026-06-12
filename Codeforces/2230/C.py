for _ in range(int(input())):
	#code
	n = int(input())
	c = [*map(int, input().split())]
	if sum(c) < 3:
		print(0)
		return
	# samples seem to always use all of a number
	# makes sense ig, if we have some triplet (x,y,z) i can just stick another y in there
	# any single that appears must be surrounded by 4 of the same number
	# even if i do (x, x, single), i'm gonna get (x, single, ?) next, which must be ? = x
	# so just alternate between 2, single, 2, single, ..., 2
	# each number appearing multiple times supports (freq/2)-1 singles?
	singles = sum(1 for x in c if x == 1)
	supported = sum(0 if x == 1 else x//2 - 1 for x in c)
	if singles + 1 == n:
		# exactly one element > 1, so we can use the wraparound
		supported += 1
	print((sum(c) - singles) + min(supported, singles))