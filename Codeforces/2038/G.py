def query(x):
	print(1, x, flush=True)
	return int(input())

def answer(i, c):
	print(0, i, c, flush=True)
	result = int(input())
	if result == -1:
		exit()

for _ in range(int(input())):
	n = int(input())
	answer(n, 0 if query(11) + query(10) == query(1) else 1)