#Problem: https://codeforces.com/contest/1556/problem/A

for _ in range(int(input())):
  a,b = map(int, input().split())
  if a == b:
    print(0 if a == 0 else 1)
  else:
    print(2 if (a+b) % 2 == 0 else -1)
