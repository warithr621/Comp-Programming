for _ in range(int(input())):
    n = int(input())
    ans = 1
    while n > 3:
        ans, n = ans << 1, n >> 2
    print(ans)