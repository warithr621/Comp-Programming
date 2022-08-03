import java.util.*;
import java.io.*;

public class Carla {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("carla.dat"));
        while(sc.hasNext()) {
            char[] ch = sc.next().toCharArray();
            char f = ch[0] == 'F' ? '-' : (char) (ch[0] + 32);
            String p = "" + f;
            for (int i = 1; i <= 3; i++) {
                switch(ch[i]) {
                    case '0':
                        p += "---";
                        break;
                    case '1':
                        p += "--x";
                        break;
                    case '2':
                        p += "-w-";
                        break;
                    case '3':
                        p += "-wx";
                        break;
                    case '4':
                        p += "r--";
                        break;
                    case '5':
                        p += "r-x";
                        break;
                    case '6':
                        p += "rw-";
                        break;
                    case '7':
                        p += "rwx";
                        break;
                    
                }
            }
            System.out.println(p);
        }
    }
}