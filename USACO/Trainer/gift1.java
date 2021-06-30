/*
ID: warithr1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    // static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int T = 1;
    public static void main(String args[]) throws IOException, FileNotFoundException{

    	BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int p = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            ArrayList<String> al = new ArrayList<String>();
            for (int i = 0; i < p; i++) {
                String temp = br.readLine();
                hm.put(temp, 0);
                al.add(temp);
            }
            while(p-->0) {
                String giver = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
                int money = Integer.parseInt(st.nextToken()), rec = Integer.parseInt(st.nextToken());
                if (rec != 0) {
                    int person = money / rec;
                    hm.put(giver, hm.get(giver) - person * rec);
                    while(rec-->0) {
                        String take = br.readLine();
                        hm.put(take, hm.get(take) + person);
                    }
                }
            }
            for (String str : al) out.printf("%s %d%n", str, hm.get(str));
        }
        br.close(); out.close();
    }
}