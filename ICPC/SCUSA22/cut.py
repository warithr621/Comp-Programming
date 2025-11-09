flights = []
n = int(input())
for i in range(n):
	a = [*map(int, input().split())]
	for j in range(n):
		if a[j] != -1:
			flights.append((i+1, j+1, a[j]))

flights.sort()
flights = [f"{x} {y} {z}" for x, y, z in flights]
print(len(flights))
print("\n".join(flights))