for _ in range(int(input())):
	N = int(input())
	H, W = 0, 0
	for i in range(N):
		h, w = map(int, input().split())
		H, W = max(H, h), max(W, w)
	print(2 * (H + W))