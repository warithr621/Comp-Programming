# https://codeforces.com/contest/1762/problem/B

for _ in range(int(input())):
    n = int(input())
    print(n) # just use all operations loll
    a = list(map(int, input().split()))
    
    for i in range(n):
        cur = 1
        while cur < a[i]:
            cur <<= 1
        print(i+1, cur - a[i])