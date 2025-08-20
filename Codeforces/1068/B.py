ans = 0
n = int(input())
i = 1
while i * i <= n:
	if n % i == 0:
		ans += 1
		if i * i != n:
			ans += 1
	i += 1
print(ans)