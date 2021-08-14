#Problem: https://atcoder.jp/contests/abc214/tasks/abc214_a
n = int(input())
if n <= 125:
    print(4)
else:
    print(6 if n < 212 else 8)
