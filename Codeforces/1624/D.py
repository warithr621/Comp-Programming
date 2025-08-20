# peak short code
from collections import Counter
for _ in range(int(input())):
	n,k=map(int,input().split())
	f=Counter(input()).values()
	p=sum(x//2 for x in f)
	print(2*(p//k)+((n-2*p)+2*(p%k)>=k))