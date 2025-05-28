for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	# there must be a loser, and between two people there must be a winner
	works = a.count(0) > 0
	for i in range(n-1):
		works &= a[i] + a[i+1] > 0
	print("YES" if not works else "NO")