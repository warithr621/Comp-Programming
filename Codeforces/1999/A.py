# https://codeforces.com/contest/1999/problem/A

for _ in range(int(input())):
    a = [ord(c) - ord('0') for c in input()]
    print(sum(a))