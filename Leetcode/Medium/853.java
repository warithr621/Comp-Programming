// https://leetcode.com/problems/car-fleet/description/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], 1.0 * (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a.pos, b.pos));
        int ans = 0, t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t-1].time) ++ans;
            else cars[t-1] = cars[t];
        }
        return ans + 1;
    }
}

class Car {
    int pos;
    double time;
    Car(int p, double t) {
        this.pos = p;
        this.time = t;
    }
}