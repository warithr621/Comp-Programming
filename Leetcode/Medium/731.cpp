// https://leetcode.com/problems/my-calendar-ii/description/?envType=daily-question&envId=2024-09-27

class MyCalendarTwo {
public:

    vector< pair<int, int> > bookings, intervals;

    MyCalendarTwo() {
        
    }
    
    bool book(int start, int end) {
        pair<int, int> p = {start, end};
        for (auto b : intervals) {
            if (overlaps(b, p)) return false;
        }
        for (auto b : bookings) {
            if (overlaps(b, p)) {
                intervals.push_back(combine(b, p));
            }
        }
        bookings.push_back(p);
        return true;
    }

    bool overlaps(pair<int, int> p1, pair<int, int> p2) {
        return max(p1.first, p2.first) < min(p1.second, p2.second);
    }
    pair<int, int> combine(pair<int, int> p1, pair<int, int> p2) {
        return {max(p1.first, p2.first), min(p1.second, p2.second)};
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(start,end);
 */