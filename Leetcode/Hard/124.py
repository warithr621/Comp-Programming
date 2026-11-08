# https://leetcode.com/problems/binary-tree-maximum-path-sum/?envType=problem-list-v2&envId=plakya4j

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode | None) -> int:
        # for each node, store max path starting from it going left, starting from it going right, and just going through it at some point
        def f(n):
            if n is None:
                return [-float('inf')] * 4
            l, r = f(n.left), f(n.right)
            cur = [n.val + max(0, l[0], l[2]),
                    n.val + max(0, l[0], l[2]) + max(0, r[0], r[2]),
                    n.val + max(0, r[0], r[2])]
            cur.append(max([l[-1], r[-1]] + cur))
            # print(n.val, cur)
            return cur
        return f(root)[-1]
            