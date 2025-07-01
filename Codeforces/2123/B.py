for _ in range(int(input())):
	n, j, k = map(int, input().split())
	a = [*map(int, input().split())]
	print("YES" if k >= 2 or a[j-1] == max(a) else "NO")