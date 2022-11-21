# 2018 Feb Silver P1

# import sys
# read = sys.stdin.readline
# write = sys.stdout.write


read = open("reststops.in", "r").readline
write = open("reststops.out", "w").write

L, N, F, B = map(int, read().split())
#L = len, N = num of stops, F = john's sec/m, B = bessie's sec/m

stops = []
for i in range(N):
    pos, taste = map(int, read().split())
    stops.append([pos, taste])
    #[i][0] = pos, [i][1] = tastiness
    
#optimal is to go to a stop and stay there for as long as possible
#i.e. until john reaches the stop bessie is at, then bessie moves john
#NEW APPROACH: suffix maxes based on tastiness?
cur_max = 0
best = []
for i in range(L+10): best.append(False);
for i in range(N-1, -1, -1):
    if stops[i][1] > cur_max:
        cur_max = stops[i][1]
        best[stops[i][0]] = True

diff = F - B
#diff represents how much longer it takes John to travel a meter than bessie
#NEW APPROACH: now we only visit the "best" stops
ans = 0
cur_pos = 0

for i in range(N):
    if best[stops[i][0]]:
        ans += stops[i][1] * diff * (stops[i][0] - cur_pos)
        cur_pos = stops[i][0]

write(str(ans) + '\n')