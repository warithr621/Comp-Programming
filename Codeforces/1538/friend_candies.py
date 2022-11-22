# Problem: https://codeforces.com/problemset/problem/1538/B

for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    sum = 0
    for i in range(n):
        sum += L[i]
    if sum % n != 0:
        print(-1)
    else:
        cnt = 0
        for i in range(n):
            if L[i] > sum // n:
                cnt += 1
        print(cnt)