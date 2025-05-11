n = int(input())
a = [*map(int, input().split())]
ans = 100000000000
for goal in range(0, 360):
    cur = 0
    for x in a:
        cur += abs(goal - x)
    ans = min(ans, cur)
print(ans)