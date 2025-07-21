for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    freq = [0 for _ in range(21)]
    for x in a:
        freq[x] += 1
    print(sum([x // 2 for x in freq]))