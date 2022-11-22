# Problem: https://codeforces.com/contest/1038/problem/C

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
print(sum(a) - sum(sorted(a+b)[::2]))
