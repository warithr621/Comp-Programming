// https://leetcode.com/problems/longest-substring-of-one-repeating-character/?envType=daily-question&envId=2026-08-13

class Node {
    char left, right;
    int pfx, sfx, longest;

    Node(char left, char right, int pfx, int sfx, int longest) {
        this.left = left;
        this.right = right;
        this.pfx = pfx;
        this.sfx = sfx;
        this.longest = longest;
    }
}

class Segtree {
    int n;
    Node[] tree;

    Segtree(String s) {
        this.n = s.length();
        tree = new Node[4*n];
        build(s, 0, 0, n-1);
    }

    void build(String s, int tn, int l, int r) {
        if (l == r) {
            tree[tn] = new Node(s.charAt(l), s.charAt(r), 1, 1, 1);
            return;
        }
        int m = (l + r) / 2;
        int a = 2 * tn + 1, b = 2 * tn + 2;
        build(s, a, l, m);
        build(s, b, m+1, r);
        int sizeA = m - l + 1, sizeB = r - m;
        char nodeLeft = tree[a].left, nodeRight = tree[b].right;
        int nodePfx = tree[a].pfx, nodeSfx = tree[b].sfx;
        if (tree[a].longest == sizeA && tree[a].right == tree[b].left) {
            nodePfx += tree[b].pfx;
        }
        if (tree[b].longest == sizeB && tree[b].left == tree[a].right) {
            nodeSfx += tree[a].sfx;
        }
        int nodeLongest = Math.max(tree[a].longest, tree[b].longest);
        if (tree[a].right == tree[b].left) {
            nodeLongest = Math.max(nodeLongest, tree[a].sfx + tree[b].pfx);
        }
        tree[tn] = new Node(nodeLeft, nodeRight, nodePfx, nodeSfx, nodeLongest);
    }

    void update(int idx, char c) {
        update(idx, c, 0, 0, n-1);
    }

    void update(int idx, char c, int tn, int l, int r) {
        if (l == r) {
            tree[tn] = new Node(c, c, 1, 1, 1);
            return;
        }
        int m = (l + r) / 2;
        int a = 2 * tn + 1, b = 2 * tn + 2;
        if (idx <= m) update(idx, c, a, l, m);
        else update(idx, c, b, m+1, r);

        int sizeA = m - l + 1, sizeB = r - m;
        char nodeLeft = tree[a].left, nodeRight = tree[b].right;
        int nodePfx = tree[a].pfx, nodeSfx = tree[b].sfx;
        if (tree[a].longest == sizeA && tree[a].right == tree[b].left) {
            nodePfx += tree[b].pfx;
        }
        if (tree[b].longest == sizeB && tree[b].left == tree[a].right) {
            nodeSfx += tree[a].sfx;
        }
        int nodeLongest = Math.max(tree[a].longest, tree[b].longest);
        if (tree[a].right == tree[b].left) {
            nodeLongest = Math.max(nodeLongest, tree[a].sfx + tree[b].pfx);
        }
        tree[tn] = new Node(nodeLeft, nodeRight, nodePfx, nodeSfx, nodeLongest);
    }

    int query() {
        return tree[0].longest;
    }

}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Segtree st = new Segtree(s);
        int m = queryIndices.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            st.update(queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.query();
        }
        return ans;
    }
}