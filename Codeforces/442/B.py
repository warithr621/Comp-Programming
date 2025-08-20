n = int(input())
a = [*map(float, input().split())]
a.sort(reverse=True)
ans = a[0]
for i in range(1, n):
	# everything in interval [0, i]
	running = 0
	for picked in range(i+1):
		sus = a[picked]
		for j in range(i+1):
			if j != picked:
				sus *= (1 - a[j])
		running += sus
	# print(running)
	ans = max(ans, running)
print(ans)