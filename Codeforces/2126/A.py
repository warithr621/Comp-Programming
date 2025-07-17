# wow wrong answer because i didn't see non-negative, thought i was cooked

def solve():
    #code
    n = int(input())
    ans = 0
    while True:
    	works = False
    	for c in '0123456789':
    		works |= (c in str(n) and c in str(ans))
    	if works:
    		print(ans)
    		return
    	ans += 1

t = int(input())
for quack in range(t):
    solve()
