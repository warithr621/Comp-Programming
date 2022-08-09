// Rakesh

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Rakesh {
	static Scanner sc;


	static boolean special(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) return true;
		}
		return false;
	}
	static boolean digit(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') return true;
		}
		return false;
	}
	static boolean UP(String s) {
		int a = 0, b = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) ++a;
			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') ++b;
		}
		return a > 0 && a == b;
	}
	static boolean letters(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) return true;
		}
		return false;
	}
	static boolean upper(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') return true;
			
		}
		return false;
	}
	static boolean lower(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') return true;
			
		}
		return false;
	}

	static int match(ArrayList<String> li) {
		int cnt = 0;
		for (int i = 0; i < li.size(); i++) {
			for (int j = i+1; j < li.size(); j++) {
				if (li.get(i).equals(li.get(j))) ++cnt;
			}
		}
		return cnt;
	}
	static int pfx(ArrayList<String> li) {
		int cnt = 0;
		for (int i = 0; i < li.size(); i++) {
			for (int j = 0; j < li.size(); j++) {
				if (li.get(i).length() >= 3 && li.get(j).length() != li.get(i).length()
					&& li.get(j).indexOf(li.get(i)) == 0) ++cnt;
			}
		}
		return cnt;
	}
	static int sfx(ArrayList<String> li) {
		int cnt = 0;
		for (int i = 0; i < li.size(); i++) {
			for (int j = 0; j < li.size(); j++) {
				if (li.get(i).length() >= 3 && li.get(j).length() != li.get(i).length()
					&& li.get(j).lastIndexOf(li.get(i)) != -1
					&& li.get(j).lastIndexOf(li.get(i)) == li.get(j).length() - li.get(i).length())
						++cnt;
			}
		}
		return cnt;
	}

	static void solve() {
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		ArrayList<String> li = new ArrayList<>();
		HashSet<String> w = new HashSet<>();
		int score = 0;
		for (String str : arr) {
			li.add(str);
			if (str.length() >= 4) w.add(str);
		}
		if (w.size() >= 4 && s.length() >= 20) {
			score = 100;
			score += (li.size() - 4) * 10;
			int sp = 0, dig = 0, allup = 0, let = 0, up = 0, low = 0;
			for (String str : li) {
				if (special(str)) ++sp;
				if (digit(str)) ++dig;
				if (UP(str)) ++allup;
				if (letters(str)) ++let;
				if (upper(str)) ++up;
				if (lower(str)) ++low;
			}
			score += sp * 5 + dig * 5;
			if (allup * 2 >= li.size()) allup = 0;
			score += allup * 10;
			if (let >= 2 && (up == 0 || low == 0)) score -= 10;
			score -= match(li) * 20 + pfx(li) * 10 + sfx(li) * 10;
		}
		String rate = "Unacceptable";
		if (score >= 150) rate = "Excellent";
		else if (score >= 125) rate = "Strong";
		else if (score >= 100) rate = "Adequate";
		else if (score >= 75) rate = "Weak";
		else if (score >= 50) rate = "Poor";
		out.printf("%d:%s\n", score, rate);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// sc = new Scanner(System.in);
		sc = new Scanner(new File("rakesh.dat"));
		while(sc.hasNextLine()) solve();
	}
} 
