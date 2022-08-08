// Opus

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Opus {
	static Scanner sc;

	static void solve() {
    	String[] tmp = sc.nextLine().split(" ");
    	char[] key = new char[40];
    	for (int i = 1; i <= 40; i++) key[i-1] = tmp[i].charAt(0);
    	ArrayList<Student> al = new ArrayList<>();
    	while(sc.hasNextLine()) {
    	    al.add(new Student(sc.nextLine(), key));
    	}
    	Collections.sort(al);
    	String cur = al.get(0).cl; int pos = 1;
    	out.println(cur);
    	for (int i = 0; i < al.size(); i++) {
    	    if (i > 0 && al.get(i).equals(al.get(i-1))) out.print((pos-1) + " ");
    	    else out.print(pos + " ");
    	    out.println(al.get(i));
    	    
    	    if (i < al.size() - 1 && !al.get(i).cl.equals(al.get(i+1).cl)) {
    	        cur = al.get(i+1).cl;
    	        out.println(cur);
    	        pos = 1;
    	    } else ++pos;
    	}
	}

	public static void main(String[] args) throws FileNotFoundException {
	   // sc = new Scanner(System.in);
		sc = new Scanner(new File("opus.dat"));
		solve();
	}
}

class Student implements Comparable<Student> {
    String name, school, cl; //cause 'class' is a keyword smh
    int score, R, W, S;
    double acc;
    
    public Student(String tmp, char[] key) {
        String[] s = tmp.split(" ");
        name = String.format("%s, %s", s[1], s[0]);
        school = s[2]; cl = s[3];
        R = 0; W = 0; S = 0;
        for (int i = 0; i < 40; i++) {
            char correct = key[i], answered = s[i+4].charAt(0);
            if (correct == answered) ++R;
            else if (answered == 'S') ++S;
            else ++W;
        }
        score = 6 * R - 2 * W;
        acc = R / 1.0 / (R+W);
    }
    
    public int compareTo(Student s) {
        if (this.cl.compareTo(s.cl) < 0) return -1;
        if (this.cl.compareTo(s.cl) > 0) return 1;
        if (this.score > s.score) return -1;
        if (this.score < s.score) return 1;
        if (this.acc > s.acc) return -1;
        if (this.acc < s.acc) return 1;
        return this.name.compareTo(s.name);
    }
    
    public String toString() {
        return String.format("%s - %s: %d", name, school, score);
    }
    public boolean equals(Student s) {
        return this.cl.equals(s.cl) && this.score == s.score && this.R == s.R;
    }
}