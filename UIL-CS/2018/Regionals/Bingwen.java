import java.util.*;
import java.lang.*;
import java.io.*;

public class Bingwen {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("bingwen.dat"));
        while(sc.hasNext()) {
            System.out.printf("%.2f\n", Math.cbrt(sc.nextDouble()));
        }
    }
}