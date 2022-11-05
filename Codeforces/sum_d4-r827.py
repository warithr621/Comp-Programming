# https://codeforces.com/contest/1742/problem/A

for _ in range(int(input())):
    a,b,c = map(int, input().split())
    print("YES" if max(a,b,c)*2 == a+b+c else "NO")