import java.util.*;
import java.io.*;

public class Milo {

	public static String romanize(int x) {
		String s = "";
		while(x >= 1000) {
			s += 'M';
			x -= 1000;
		}
		if (x >= 900) {
			s += "CM";
			x -= 900;
		}
		if (x >= 500) {
			s += 'D';
			x -= 500;
		}
		if (x >= 400) {
			s += "CD";
			x -= 400;
		}
		while(x >= 100) {
			s += 'C';
			x -= 100;
		}
		if (x >= 90) {
			s += "XC";
			x -= 90;
		}
		if (x >= 50) {
			s += 'L';
			x -= 50;
		}
		if (x >= 40) {
			s += "XL";
			x -= 40;
		}
		while (x >= 10) {
			s += 'X';
			x -= 10;
		}

		String[] fin = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return s + fin[x];
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("milo.dat"));

		//super inefficient method:
			//generate RN conversion for 1-3999
			//search using hashmap

		HashMap<String, Integer> rn = new HashMap<>();
		for (int i = 1; i < 4000; i++) {
			rn.put(romanize(i), i);
		}

		while(sc.hasNext()) {
			System.out.println(rn.get(sc.next()));
		}
	}
}