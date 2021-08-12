//Problem: https://codeforces.com/problemset/problem/1284/B

import java.io.*;
import java.util.*;

public class ascent {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] max = new int[n];
        int[] min = new int[n];
        long out = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < l; j++) {
                int z = Integer.parseInt(st.nextToken());
                if (z > minValue) {
                    maxValue = Integer.MAX_VALUE;
                    minValue = Integer.MIN_VALUE;
                    break;
                }
                maxValue = Math.max(maxValue, z);
                minValue = Math.min(minValue, z);
            }
            max[i] = maxValue;
            min[i] = minValue;
        }
        Arrays.sort(min);
        Arrays.sort(max);
        int last = 0;
        for (int i = 0; i < n; i++) {
            boolean w = true;
            for (int j = last; j < n; j++) {
                if (max[j] > min[i]) {
                    out += (max.length - j);
                    last = j;
                    w = false;
                    break;
                }
            }
            if (w) break;
        }
        System.out.println(out);
    }
}
