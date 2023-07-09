// UIL CS 2018 State (P10)

import java.util.*;
import java.io.*;

public class Oscar {
    
    static Scanner sc;
    static char[][] ans;
    static boolean clown;
    
    static void printer() {
        if (clown) System.out.println("SIGN CANNOT BE MADE");
        else for (int i = 0; i < ans.length; i++) {
            System.out.println(new String(ans[i]));
        }
        System.out.println();
    }
    
    static void place(int line, String phrase) {
        // put in indices [1, 10]
        int len = phrase.length(), space = 10 - len;
        for (int i = 0; i < len; i++) {
            int j = i + space / 2 + 1;
            ans[line][j] = phrase.charAt(i);
            if (ans[line][j] == ' ') ans[line][j] = '.';
        }
    }
    
    public static void main(String[] args) throws IOException {
        sc = new Scanner( new File("oscar.dat") );
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            clown = false;
            // the thing should fit in a 3 x 10 array
            ans = new char[5][12];
            for (int i = 0; i < 5; i++) for (int j = 0; j < 12; j++) {
                // build the original sign
                if (i == 0 || i == 4) ans[i][j] = '*';
                else if (j == 0 || j == 11) ans[i][j] = '*';
                else ans[i][j] = '.';
            }
            
            solve:
            {
                // also just go ahead and make sure no length exceeds 10
                for (String str : arr) clown |= (str.length() > 10);
                if (clown) break solve;
                
                if (arr.length == 1) {
                    // put this in middle line
                    place(2, arr[0]);
                } else if (arr.length == 2) {
                    place(1, arr[0]);
                    place(2, arr[1]);
                } else {
                    // remember that we need to try to use up all three lines
                    // but also put as much on the first line as possible
                    int[] pos = new int[arr.length];
                    int curlen = 0;
                    int curpos = 1;
                    for (int i = 0; i < pos.length; i++) {
                        if (curlen + arr[i].length() + (curlen == 0 ? 0 : 1) <= 10) {
                            pos[i] = curpos;
                            curlen += arr[i].length() + (curlen == 0 ? 0 : 1);
                        } else {
                            pos[i] = (++curpos);
                            curlen = arr[i].length();
                        }
                    }
                    
                    if (curpos > 3) {
                        clown = true;
                        break solve; // cannot fit in 3 lines
                    }
                    if (curpos != 3) {
                        // adjust lines
                        pos[pos.length-1] = 3;
                        pos[pos.length-2] = 2;
                    }
                    
                    String[] lines = new String[]{"", "", "", ""};
                    for (int i = 0; i < pos.length; i++) lines[pos[i]] += (lines[pos[i]].length() == 0 ? "" : " ") + arr[i];
                    for (int i = 1; i <= 3; i++) place(i, lines[i]);
                }
            }
            
            printer();
        }
        
        sc.close();
    }
}