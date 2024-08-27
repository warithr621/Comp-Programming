# https://codeforces.com/contest/2000/problem/A

def solve():
    s = input()
    if len(s) <= 2:
        return "NO"
    if s[:2] != "10":
        return "NO"
    if len(s) == 3:
        return "NO" if (s[2] == '0' or s[2] == '1') else "YES"
    return "NO" if (s[2] == '0') else "YES"

for _ in range(int(input())):
    print(solve())