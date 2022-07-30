#Problem: https://codeforces.com/problemset/problem/1433/B
for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    left = 0
    right = n-1
    while L[left] == 0:
        left += 1
    while L[right] == 0:
        right -= 1
    cnt = 0
    for i in range(left, right):
        if L[i] == 0:
            cnt += 1
    print(cnt)