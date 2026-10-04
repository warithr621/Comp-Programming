import java.util.*;

public class G {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int N = sc.nextInt(), Q = sc.nextInt(), G = sc.nextInt();
			Map<Integer, Integer> last = new HashMap<>(), cnt = new HashMap<>();
			while(Q --> 0) {
				char type = sc.next().charAt(0);
				if (type == 'P') {
					int s = sc.nextInt(), a = sc.nextInt();
					if (!cnt.containsKey(s)) cnt.put(s, 0);
					for (int i = 0; i < a; i++) {
						int ia = sc.nextInt();
						if (!last.containsKey(ia)) {
							last.put(ia, s);
						} else {
							int prev = last.get(ia);
							cnt.put(prev, cnt.get(prev)-1);
							last.put(ia, s);
						}
					}
					cnt.put(s, cnt.get(s)+a);
				} else if (type == 'Q') {
					int s = sc.nextInt();
					if (!cnt.containsKey(s)) cnt.put(s, 0);
					System.out.println(cnt.get(s));
				}
			}
		}
	}
}