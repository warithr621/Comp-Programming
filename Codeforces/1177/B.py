k = int(input())
if k <= 9:
	print(k)
	exit()

k -= 1 # hehe
pw, l = 1, 1
while 9 * pw * l < k:
	k -= 9 * pw * l
	pw *= 10
	l += 1
ans = pw + k / l
print(str(ans)[k % l])