for _ in range(int(input())):
    n, d = map(int, input().split())
    ans = "1 "
    if d % 3 == 0 or n >= 3:
        ans += "3 "
    if d == 5:
        ans += "5 "
    if d == 7 or n >= 3:
        ans += "7 "
    # we need d * n! to be a multiple of 9
    if d == 9 or n >= 6 or (d % 3 == 0 and n >= 3):
        ans += "9 "
    
    print(ans)