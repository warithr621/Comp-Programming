import java.util.*;
import java.lang.*;
import java.io.*;

public class Brenda {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("brenda.dat"));
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        for (int x : a) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) System.out.print("X");
                System.out.println();
            }
            for (int i = 0; i < 20; i++) System.out.print("-");
            System.out.println();
        }
    }
}