class Solution {
public:
    double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        double H = hour * 30 + minutes * 0.5;
        double M = minutes * 6;
        double diff = abs(H - M);
        return min(diff, 360 - diff);
    }
};