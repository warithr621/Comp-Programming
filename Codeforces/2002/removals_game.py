# https://codeforces.com/contest/2002/problem/B

for _ in range(int(input())):
    n = int(input())
    a = [*map(str, input().split())]
    b = [*map(str, input().split())]
    if a == b:
        print("Bob")
    else:
        a = a[::-1]
        print("Bob" if a == b else "Alice")