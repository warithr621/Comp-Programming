n = int(input())
a = [*map(int, input().split())]
mx = max(a)
print("YES" if sum(a) % 2 == 0 and mx <= sum(a) - mx else "NO")