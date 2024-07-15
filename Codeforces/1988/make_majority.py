# https://codeforces.com/contest/1988/problem/B

for _ in range(int(input())):
    n = int(input())
    a = input()
    ok = (a.count("111") >= 1) or (a.count("11") >= 2)
    ok |= (a.count("11") >= 1 and (a[0] == "1" or a[-1] == "1"))
    ok |= (a[0] == "1" and a[-1] == "1")
    print("YES" if ok else "NO")