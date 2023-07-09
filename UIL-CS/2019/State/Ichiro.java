// UIL CS 2019 State (P5)

import java.util.*;
import java.io.*;

public class Ichiro {
    
    static Scanner sc;
    
    public static void main(String[] args) throws IOException {
        // sc = new Scanner(System.in);
        sc = new Scanner( new File("ichiro.dat") );
        int T = sc.nextInt();
        while (T --> 0) {
            String[] tmp = sc.next().split("[:,]");
            int[] dim = new int[6];
            for (int i = 0; i < 6; i++) dim[i] = Integer.parseInt(tmp[i]);
            
            double a[][][] = new double[dim[1] - dim[0] + 1][dim[3] - dim[2] + 1][dim[5] - dim[4] + 1];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    tmp = sc.next().split(",");
                    for (int k = 0; k < a[0][0].length; k++) {
                        a[i][j][k] = Double.parseDouble(tmp[k]);
                    }
                }
            }
            
            int N = sc.nextInt();
            while(N --> 0) {
                tmp = sc.next().split("[:,]");
                int[] slice = new int[6];
                for (int i = 0; i < 6; i++) slice[i] = Integer.parseInt(tmp[i]);
                
                int sz = (slice[1] - slice[0] + 1) * (slice[3] - slice[2] + 1) * (slice[5] - slice[4] + 1);
                double sum = 0;
                for (int i = slice[0]; i <= slice[1]; i++) {
                    for (int j = slice[2]; j <= slice[3]; j++) {
                        for (int k = slice[4]; k <= slice[5]; k++) {
                            sum += a[i - dim[0]][j - dim[2]][k - dim[4]];
                        }
                    }
                }
                
                System.out.printf("%d:%.2f\n", sz, sum);
            }
            System.out.println("===============");
        }
        
        sc.close();
    }
}