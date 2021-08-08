//Problem 7

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Opus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new File("opus.dat"));
        String s = sc.nextLine();
        char[] key = new char[40];
        Scanner temp = new Scanner(s); temp.next();
        for (int i = 0; i < 40; i++) key[i] = temp.next().charAt(0);
        ArrayList<Student> list = new ArrayList<Student>();
        while(sc.hasNext()) {
            Student st = new Student(sc.nextLine(), key);
            list.add(st);
        }
        Collections.sort(list);
        int place = 1;
        String conf = list.get(0).conf;
        out.println(conf);
        
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).unbreak(list.get(i-1))) out.print(place - 1 + " ");
            else out.print(place + " ");
            out.println(list.get(i));
            if (i < list.size() - 1 && !list.get(i+1).conf.equals(conf)) {
                conf = list.get(i+1).conf;
                out.println(conf);
                place = 1;
            } else ++place;
        }
    }
}

class Student implements Comparable<Student> {
    String first, last, school, conf;
    char[] ans = new char[40];
    int score; double acc;
    public boolean unbreak(Student s) {
        return this.acc == s.acc;
    }
    public int compareTo(Student s) {
        if (this.conf.compareTo(s.conf) < 0) return -1;
        if (this.conf.compareTo(s.conf) > 0) return 1;
        if (this.score > s.score) return -1;
        if (this.score < s.score) return 1;
        if (this.acc < s.acc) return 1;
        if (this.acc > s.acc) return -1;
        if (this.last.compareTo(s.last) > 0) return 1;
        if (this.last.compareTo(s.last) < 0) return -1;
        if (this.first.compareTo(s.first) > 0) return 1;
        if (this.first.compareTo(s.first) < 0) return -1;
        return 0;
    }
    public String toString() {
        return last + ", " + first + " - " + school + ": " + score;
    }
    public Student(String s, char[] key) {
        Scanner k = new Scanner(s);
        first = k.next(); last = k.next();
        school = k.next(); conf = k.next();
        int right = 0, wrong = 0;
        for (int i = 0; i < 40; i++) {
            char a = k.next().charAt(0);
            ans[i] = a;
            if (key[i] == ans[i]) ++right;
            else if (ans[i] != 'S') ++wrong;
        }
        acc = (double) right / (right + wrong);
        score = 6 * right - 2 * wrong;
    }
}
