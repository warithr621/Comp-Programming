//Problem 10

import java.io.*;
import java.util.*;

public class Rajeev {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("rajeev.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String s;
            while((s = br.readLine()) != null) {
                String[] temp = s.split(",");
                String file = temp[0], owner = temp[1];
                ArrayList<String> al = new ArrayList<String>();
                for (int i = 2; i < temp.length; i++) {
                    String[] hm = temp[i].split("@");
                    if (!hm[1].equals("uiltexas.org") && !hm[1].equals("uil.net")) al.add(temp[i]);
                }
                if (al.size() != 0) {
                    out.printf("%s:%s", file, owner);
                    for (String str : al) out.print(":" + str);
                    out.println();
                }
            }
        }
        br.close(); out.close();
    }
}
