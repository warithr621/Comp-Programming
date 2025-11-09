n = int(input())
a = [*map(int, input().split())]


if len(set(a)) != len(a):
	print(0, 6**(4-n))
elif n == 3:
	print(3, 3)
elif n == 2:
	print(12, 24)
else:
	print(60, 156)