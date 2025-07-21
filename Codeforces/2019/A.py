# https://codeforces.com/contest/2019/problem/A

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    odd, even = [0,0], [0,0]
    for i in range(n):
        x = a[i]
        if i % 2 == 1:
            odd[0] += 1
            odd[1] = max(odd[1], x)
        else:
            even[0] += 1
            even[1] = max(even[1], x)
    print(max(sum(odd),sum(even)))