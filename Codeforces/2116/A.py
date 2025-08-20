for _ in range(int(input())):
	a, b, c, d = map(int, input().split())
	# take turns either attacking opponent or reducing opponent's attack
	# if your knight is killed you can only take damage
	# so the optimal strategy is to either kill off opponent or their knight, whichever has less health
	print("Gellyfish" if min(a,c) >= min(b,d) else "Flower")