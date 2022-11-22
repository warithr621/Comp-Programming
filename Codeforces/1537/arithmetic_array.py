#Problem: https://codeforces.com/problemset/problem/1537/A
for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    sum = 0
    for i in range(n):
        sum += L[i]
    if n == sum:
        print(0)
    elif n > sum:
        print(1)
    else:
        print(sum - n)