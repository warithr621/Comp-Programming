import java.util.*;
import java.io.*;

public class Dilbert {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("dilbert.dat"));
		ArrayList<Member> al = new ArrayList<>();
		while(sc.hasNext()) {
			String name = sc.next() + " " + sc.next();
			String date = sc.next();
			double price = sc.nextDouble();

			//time for bad searching
			boolean in = false;
			for (int i = 0; i < al.size(); i++) {
				if (al.get(i).name.equals(name)) {
					al.get(i).addEntry(date, price);
					in = true;
				}
			}

			if (!in) {
				al.add(new Member(name, date, price));
			}
		}

		Collections.sort(al);
		double tot = 0;
		for (Member m : al) {
			System.out.println(m);
			tot += m.sum;
		}
		System.out.printf("Grand Total $%.2f\n", tot);
	}
}

class Member implements Comparable<Member> {
	String name;
	ArrayList<Entry> ale;
	double sum = 0;

	public Member(String s, String t, double d) {
		this.name = s;
		ale = new ArrayList<>();
		ale.add(new Entry(t, d));
		sum += d;
	}

	public void addEntry(String s, double d) {
		ale.add(new Entry(s, d));
		sum += d;
	}

	public int compareTo(Member m) {
		return this.sum > m.sum ? -1 : 1;
	}

	public String toString() {
		String ret = name + '\n';
		Collections.sort(ale);
		for (Entry e : ale) ret += e + "\n";
		return ret + String.format("Total Sales $%.2f\n", sum);
	}
}

class Entry implements Comparable<Entry>{
	// the fact this uses two other classes is kind of inefficient
	// but i'll fix that later, maybe
	String date;
	double price;
	int mon, day, yr;

	public Entry(String s, double d) {
		this.date = s;
		this.price = d;

		String[] arr = date.split("/");
		mon = Integer.parseInt(arr[0]);
		day = Integer.parseInt(arr[1]);
		yr = Integer.parseInt(arr[2]);
	}

	public int compareTo(Entry e) {
		if (this.yr < e.yr) return -1;
		if (this.yr > e.yr) return 1;
		if (this.mon < e.mon) return -1;
		if (this.mon > e.mon) return 1;
		return (this.day < e.day ? -1 : 1);
	}

	public String toString() {
		return String.format("%s $%.2f", date, price);
	}
}