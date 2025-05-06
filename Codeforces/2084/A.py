for _ in range(int(input())):
    n = int(input())
    if n % 2 == 0:
        print(-1)
    else:
        print(n, end='')
        for i in range(1, n):
            print(" " + str(i), end='')
        print()