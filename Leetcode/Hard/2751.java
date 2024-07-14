// https://leetcode.com/problems/robot-collisions/?envType=daily-question&envId=2024-07-13
// this was actually pretty fun to do for a "Hard" problem,
// minus the fact that my ArrayList (as opposed to stack solution) TLEd on only like 5 cases so I had to redo a bunch

import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        ArrayList<Robot> al = new ArrayList<>();
        Stack<Robot> st = new Stack<>();
        for (int i = 0; i < positions.length; i++) {
            Robot r = new Robot(i, positions[i], healths[i], directions.charAt(i));
            al.add(r);
        }
        Collections.sort(al);
        for (Robot r : al) {
            if (r.dir == 'R') st.push(r);
            else {
                boolean dead = false, pushed = false;
                while (!st.empty()) {
                    Robot fight = st.peek();
                    if (fight.dir == 'L') {
                        st.push(r);
                        pushed = true;
                        break;
                    }
                    if (r.health == fight.health) {
                        st.pop();
                        dead = true;
                        break;
                    }
                    if (r.health > fight.health) {
                        st.pop();
                        r.hit();
                    } else {
                        st.pop();
                        fight.hit();
                        st.push(fight);
                        dead = true;
                        break;
                    }
                }
                if (!dead && !pushed) st.push(r);
            }
        }
        Collections.sort(st, new Comparator<Robot>() {
            public int compare(Robot r, Robot rr) {
                return r.id - rr.id;
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (Robot r : st) ans.add(r.health);

        return ans;
    }
}

class Robot implements Comparable<Robot> {
    int id, pos, health;
    char dir;
    Robot(int n, int x, int h, char d) {
        this.id = n;
        this.pos = x;
        this.health = h;
        this.dir = d;
    }
    public void hit() {
        --health;
    }
    public int compareTo(Robot r) {
        return this.pos - r.pos;
    }
}