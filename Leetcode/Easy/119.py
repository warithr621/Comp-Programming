# https://leetcode.com/problems/pascals-triangle-ii/

class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1,1]
        row = [1,1]
        while len(row) != rowIndex + 1:
            nxt = [1]
            for i in range(len(row)-1):
                nxt.append(row[i] + row[i+1])
            nxt.append(1)
            row = nxt
        return row