// Problem: https://codeforces.com/contest/812/problem/B

import java.util.*;

public class SagheerHausmeister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        M += 2; // just realized this was causing everything to be off
        String[] arr = new String[N];
        for (int i = N-1; i >= 0; i--) arr[i] = sc.next();
        int time = Integer.MAX_VALUE, idx;
        
        // edge case I didn't consider: last floor(s) may not even have any, so there's no point in going back to stairs or climbing them
        int efflast = 0; // effectively last floor, i.e. topmost floor with a light actually on
        for (int i = 0; i < N; i++) {
            if (arr[i].contains("1")) efflast = i;
        }
        
        int[] leftmost = new int[N], rightmost = new int[N];
        for (int i = 0; i < N; i++) {
            idx = 0;
            while (idx < M-1 && arr[i].charAt(idx) == '0') ++idx;
            leftmost[i] = idx;
            
            idx = M-1;
            while (idx > 0 && arr[i].charAt(idx) == '0') --idx;
            rightmost[i] = idx;
        }
        
        for (int op = 0; op < (1 << efflast); op++) {
            // 'op' basically represents how you traverse the floors
            int tmp = 0;
            boolean stair = false; // false = left, true = right
            
            for (int i = 0; i <= efflast; i++) {
                // stairs are at '0' and 'M-1', lights at '1' to 'M-2' inclusive
                if (stair) {
                    // currently on right stair
                    // find left-most light
                    idx = 0;
                    while(idx < M-1 && arr[i].charAt(idx) == '0') ++idx;
                    // travel this many steps to get to the left-most lightbulb
                    tmp += (M-1) - idx;
                } else {
                    // currently on left stair
                    // find right-most light
                    idx = M-1;
                    while(idx > 0 && arr[i].charAt(idx) == '0') --idx;
                    // travel this many steps to get to the left-most lightbulb
                    tmp += idx;
                }
                if (i != efflast) {
                    // more stairs to climb!
                    
                    // pick stair to move to, based on 'op' (0 = left, 1 = right just like the stair variable)
                    if ((op & 1 << i) == 0) {
                        tmp += idx;
                        stair = false;
                    } else {
                        tmp += (M-1) - idx;
                        stair = true;
                    }
                    
                    // then climb the stair
                    tmp++;
                }
            }
            
            time = Math.min(time, tmp);
        }
        
       
        System.out.println(time);
    }
}