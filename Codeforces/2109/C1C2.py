# note: works for both C1 and C2

def query(s):
	print(s, flush=True)
	res = input()

for i in range(int(input())):
	n = int(input())
	query("mul 9")
	query("digit")
	query("digit")
	query(f"add {n-9}")
	query("!")