import java.util.*;
import java.lang.*;
import java.io.*;

public class Barb {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("barb.dat"));
        int N = sc.nextInt();
        System.out.println("A   A*A   3*A   A/2");
        for (int i = 1; i <= N; i++) System.out.printf("%d     %d     %d     %d\n", i, i*i, 3*i, i/2);
    }
}