// Alice

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Alice {
	static Scanner sc;

	static void solve() {
		String space = "           ";
		for (int i = 1; i <= 20; i++) {
			out.print(space + '&');
			if (i != 1) out.print('&');
			if (4 <= i && i <= 7) for (int j = 0; j < i-3; j++) out.print('-');
			else if (i > 7) out.print("--");
			for (int j = 0; j < i-7; j++) out.print('.');
			if (i > 7) out.print("--");
			if (i >= 3) out.print('&');

			out.println();
		}
		out.println(space + " " + "||" + space + "        " + "\\o/");
		out.println(space + " " + "||" + space + "         " + "|");
		out.print(" ");
		for (int i = 0; i <= 37; i++) out.print("=");
		out.println();
		out.print("   ");
		for (int i = 0; i <= 33; i++) out.print("=");
		out.println();
		for (int i = 0; i <= 39; i++) out.print("^");
		out.println();
	}

	public static void main(String[] args) {
		solve();
	}
}