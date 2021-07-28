//Problem 12

import java.io.*;
import java.util.*;

public class Sara {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("sara.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            String[] bride = br.readLine().split(" ");
            String[] groom = br.readLine().split(" ");
            ArrayList<String> b = new ArrayList<String>(), g = new ArrayList<String>(), both = new ArrayList<String>();
            TreeSet<String> all = new TreeSet<String>();
            for (String s : bride) {
                b.add(s);
                all.add(s);
            }
            for (String s : groom) {
                if (b.contains(s)) {
                    b.remove(s);
                    both.add(s);
                } else g.add(s);
                all.add(s);
            }
            Collections.sort(b); Collections.sort(g); Collections.sort(both);
            out.print("Guests: ");
            for (String s : all) out.print(s + " ");
            out.print("\nGuests of Both: ");
            for (String s : both) out.print(s + " ");
            out.print("\nBride's Guests: ");
            for (String s : b) out.print(s + " ");
            out.print("\nGroom's Guests: ");
            for (String s : g) out.print(s + " ");
            out.println("\n--------------------");
        }
        br.close(); out.close();
    }
}
