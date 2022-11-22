# https://codeforces.com/contest/1742/problem/D

from math import gcd

def make():
    tmp = []
    for i in range(1001):
        tmp.append([])
    return tmp

coprime = make()

def pc():
    for i in range(1, 1001):
        for j in range(1, 1001):
            if gcd(i, j) == 1:
                # print(i, j)
                coprime[i].append(j)
                
pc()
# print(coprime[2])
for _ in range(int(input())):
    n = int(input())
    num = make()
    a = list(map(int, input().split()))
    for i in range(1, n+1):
        num[a[i-1]].append(i)
    
    ans = -1
    for i in range(1, 1001):
        for j in coprime[i]:
            if len(num[i]) != 0 and len(num[j]) != 0:
                ans = max(ans, num[i][-1] + num[j][-1])
                # print(num[i][-1], num[j][-1])
    
    
    print(ans)