def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n, k = map(int, input().split())
    a = in_li()
    bigger = []
    for x in a:
        if x > a[k-1]:
            bigger.append(x)
    bigger = sorted(list(set(bigger)))
    # print(bigger)
    height, cur = 1, a[k-1]
    for x in bigger:
        # print(height, cur, x)
        if cur+1 >= height + (x - cur):
            height += x-cur
            cur = x
        else:
            print("NO")
            return
    print("YES")

t = int(input())
for quack in range(t):
    solve()
