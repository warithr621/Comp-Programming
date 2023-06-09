// HSCTF10 rev/micrurus-fulvius

import java.util.*;

public class MicrurusFulviusSolnPartTwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> al = new ArrayList<>();
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            s = s.substring(1, s.length() - 1);
            String[] arr = s.split(", ");
            ArrayList<String> tmp = new ArrayList<>();
            for (String str : arr) {
                tmp.add(str.substring(1, 3)); // 'xy'
            }
            al.add(tmp);
        }
        String flag = "flag{";
        Queue<String> q = new LinkedList<>();
        for (String str : al.get(4)) {
            if (str.charAt(0) == '{') {
                q.add(flag + str.charAt(1) + " " + 5);
            }
        }
        
        while(!q.isEmpty()) {
            String[] s = q.poll().split(" ");
            String cur = s[0];
            Integer idx = Integer.parseInt(s[1]);
            if (idx == 14) {
                if (cur.charAt(cur.length() - 1) == '}') {
                    System.out.println(cur);
                }
                continue;
            }
            
            for (String str : al.get(idx)) {
                if (str.charAt(0) == cur.charAt(cur.length() - 1)) {
                    q.add(cur + str.charAt(1) + " " + (idx + 1));
                }
            }
        }
    }
}