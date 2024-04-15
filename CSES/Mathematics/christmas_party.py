# CSES Christmas Party

# After doing some brute forcing on small cases, I found this
# https://oeis.org/A000166

A = [1, 0, 1, 2, 9]
N = int(input())
if N <= 4:
	print(A[N])
	exit()

for i in range(5, N+1):
	A.append(i * A[-1] + (-1)**i)
	A[i] %= int(1e9 + 7)
print(A[-1])