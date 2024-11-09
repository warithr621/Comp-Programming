n, m = map(int, input().split())
beethoven = [*map(int, input().split())]
beethoven = ''.join(map(str, beethoven))
ship = []
for _ in range(n):
    ship.append([*map(int, input().split())])
    
beethoven = beethoven + beethoven
# print(beethoven)
for i in range(n):
    ship[i] = ''.join(map(str, ship[i]))
    # print(ship[i])
    if ship[i] in beethoven:
        print(i+1)
        exit(0)
        
print(-1)