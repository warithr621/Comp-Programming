// https://leetcode.com/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150

func maxSubArray(nums []int) int {
    curmax := 0
    ans := -100000
    for _, v := range nums {
        curmax += v
        if curmax > ans {
            ans = curmax
        }
        if curmax < 0 {
            curmax = 0
        }
    }

    return ans
}