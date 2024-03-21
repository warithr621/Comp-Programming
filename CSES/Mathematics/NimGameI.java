import java.util.*;

public class NimGameI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            // just xor the entire list I think??
            int N = sc.nextInt(), ans = 0;
            while (N --> 0) ans ^= sc.nextInt();
            System.out.println(ans != 0 ? "first" : "second");
        }
    }
}