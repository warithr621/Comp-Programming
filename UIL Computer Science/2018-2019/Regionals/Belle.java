//Problem 2

import java.io.*;
import java.util.*;

public class Belle {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("belle.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            out.println(Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close(); out.close();
    }
}
