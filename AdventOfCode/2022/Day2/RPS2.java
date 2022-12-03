// AoC D2 2022

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class RPS2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int ans = 0;
        
        while (sc.hasNext()) {
            char c = sc.next().charAt(0), d = sc.next().charAt(0);
            
            if (d == 'X') {
                ans += (c - 'A' + 2) % 3 + 1;
            } else if (d == 'Y') {
                ans += 3 + c - 'A' + 1;
            } else {
                ans += 6 + (c - 'A' + 1) % 3 + 1;
            }
        }
        
        out.println(ans);
    }
}