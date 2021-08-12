#Problem: https://codeforces.com/contest/1535/problem/A

for _ in range(int(input())):
    a,b,c,d = map(int, input().split())
    if max(a,b) > min(c,d) and max(c,d) > min(a,b):
        print("YES")
    else :
        print("NO")
