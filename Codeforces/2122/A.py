for _ in range(int(input())):
	n, m = map(int, input().split())
	print("NO" if min(m, n) == 1 or m == n == 2 else "YES")