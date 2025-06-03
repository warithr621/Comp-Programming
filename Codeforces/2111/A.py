def solve():
    #code
    n = int(input())
    m = n.bit_length()
    print(2 * m + 1)

t = int(input())
for quack in range(t):
    solve()