// https://leetcode.com/problems/alternating-digit-sum/

int alternateDigitSum(int n) {
    int tmp = n, cnt = 0;
    while (tmp > 0) {
        cnt++;
        tmp /= 10;
    }
    int ans = 0, sign = (cnt & 1 ? 1 : -1);
    while (n > 0) {
        ans += sign * (n % 10);
        n /= 10;
        sign = -sign;
    }
    return ans;
}