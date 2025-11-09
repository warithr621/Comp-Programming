import sys, io, os
from heapq import heappop, heappush
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
pop = heappop
push = heappush
sys.setrecursionlimit(1 << 25)

# INPUT
n, m, k = map(int, input().split())
adj = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)
racers = [[] for _ in range(n+1)]
for i in range(m):
    p, t = map(int, input().split())
    racers[p].append((0, -t, i+1)) # time, speed, id
e = int(input()) # finish checkpoint
c = int(input()) # cnt of special
special = [e] # include the root as special bcz idk
sset = set()
for _ in range(c):
    x = int(input())
    special.append(x)
    sset.add(x)

# CODE LOGIC
# for each node, note their "parent", where we root @ e
parent = [-1 for _ in range(n+1)]
depth = [0 for _ in range(n+1)]
def pdfs(u, p, d=0):
    parent[u] = p
    depth[u] = d
    for v in adj[u]:
        if v != p:
            pdfs(v, u, d+1)
pdfs(e, -1)
ans = [-1 for _ in range(m+1)]

# uh there is prob some compression details
# for each racer's path, we only care about the special nodes
special.sort(key=lambda x: -depth[x]) # deepest first
for node in special:
    # add all children racers (up to and including the next-recent special node(s))
    # and add them to this shit
    hq = []
    # dfs down
    def ndfs(u):
        # add racers at u
        for time, speed, ide in racers[u]:
            push(hq, (time + speed * (depth[u] - depth[node]), speed, ide))
        racers[u].clear()
        # if u is special, stop
        if u in sset and u != node:
            return
        for v in adj[u]:
            if v != parent[u]:
                ndfs(v)
    ndfs(node)
    # if this node is the finish like, record ans
    if node == e:
        while hq:
            time, speed, ide = pop(hq)
            ans[ide] = -time
        break
    # now we only keep the best k at this node
    while len(hq) > k:
        time, speed, ide = pop(hq)
    # the rest go to the parent
    while hq:
        time, speed, ide = pop(hq)
        racers[node].append((time, speed, ide))
    

# OUTPUT
for i in range(1, m+1):
    write(str(ans[i]) + '\n')