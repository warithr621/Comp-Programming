n, k, M, D = map(int, input().split())
ans = 0
for rounds in range(1, D+1):
	x = min(n // ((rounds-1) * k + 1), M)
	if n >= x * (rounds * k) + x: continue;
	amt = n // (k * x) * x + (x if n % (k*x) >= x else 0)
	ans = max(ans, amt)
print(ans)