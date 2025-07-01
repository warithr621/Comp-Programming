for _ in range(int(input())):
	n, k = map(int, input().split())
	s = input()
	print("Alice" if s.count('1') <= k or k > n//2 else "Bob")