//Problem: https://codeforces.com/contest/1315/problem/C

for _ in range(int(input())):
  n=int(input())
  a=list(map(int,input().split()))
  b=[0]*(2*n)
  for i in a: b[i-1]+=1
  m=0
  c=[]
  for i in range(n):
    j=a[i]
    while(j<(2*n)):
      if b[j]==0:
        b[j]+=1
        c.append(j+1)
        m+=1
        break
      else:
        j+=1
  if m!=n:
    print(-1)
  else:
    for i in range(n):
      print(a[i],c[i],end=" ")
    
