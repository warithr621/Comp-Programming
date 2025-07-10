from math import isqrt

def main():
	N = int(input())
	A = [*map(int, input().split())]
	for K in range(1, N//3 + 1):
		if N % K != 0:
			continue
		for i in range(K):
			# print(A[i::K])
			if sum(A[i::K]) == N//K:
				print("YES")
				return
	print("NO")

if __name__ == "__main__":
	main()