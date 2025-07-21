n = int(input())
a = [*map(int, input().split())]
# if one element, just itself
# if two, it's 2 * a0 + 2 * a1
# if three, 2 * a0 + 3 * a1 + 3 * a2
# if four, 2 * a0 + 3 * a1 + 4 * a2 + 4 * a3
if n == 1:
	print(a[0])
	exit()
a.sort()
ans, mult = 0, 2
for i in range(n):
	ans += a[i] * mult
	if i != n-2:
		mult += 1
print(ans)