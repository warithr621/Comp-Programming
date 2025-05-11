# CSES Hidden Integer

def query(x):
	print(f"? {x}", flush=True)
	return input()

def answer(x):
	print(f"! {x}", flush=True)

L, R = 1, int(1e9)
while L < R:
	M = (L + R) // 2
	if query(M) == "YES":
		L = M+1
	else:
		R = M
answer(L)