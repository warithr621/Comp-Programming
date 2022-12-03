// AoC D2 2022

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class RPS1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int ans = 0;
        
        while (sc.hasNext()) {
            char c = sc.next().charAt(0), d = sc.next().charAt(0);
            if (c == 'A' && d == 'Y' || c == 'B' && d == 'Z' || c == 'C' && d == 'X') ans += 6 + d - 'W';
            else if (c - 'A' == d - 'X') ans += 3 + d - 'W';
            else ans += d - 'W';
            // out.println(ans);
        }
        
        out.println(ans);
    }
}