// https://leetcode.com/problems/find-eventual-safe-states/description/?envType=daily-question&envId=2025-01-24

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool dfs(int node, int** adj, int* adjSize, bool* vis, bool* poss) {
    if (poss[node]) return true;
    if (vis[node]) return false;
    vis[node] = poss[node] = true;
    for (int i = 0; i < adjSize[node]; i++) {
        if (dfs(adj[node][i], adj, adjSize, vis, poss)) return true;
    }
    poss[node] = false;
    return false;
}

int* eventualSafeNodes(int** graph, int graphSize, int* graphColSize, int* returnSize) {
    bool* vis = (bool*) calloc(graphSize, sizeof(bool));
    bool* poss = (bool*) calloc(graphSize, sizeof(bool));
    for (int i = 0; i < graphSize; i++) {
        dfs(i, graph, graphColSize, vis, poss);
    }
    int sz = 0;
    for (int i = 0; i < graphSize; i++) {
        if (!poss[i]) ++sz;
    }
    int* ans = (int*) calloc(sz, sizeof(int));
    for (int i = 0, idx = 0; i < graphSize; i++) {
        if (!poss[i]) ans[idx++] = i;
    }
    free(vis);
    free(poss);
    *returnSize = sz;
    return ans;
}