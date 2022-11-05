// Problem 8

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Lucia {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("lucia.dat"));
        Node root = new Node(sc.nextInt());
        while(sc.hasNextInt()) root.add(sc.nextInt());
        
        String[] pre = root.preorder().split("\\s+");
        out.print("Preorder: ");
        for (String s : pre) out.print(s + " ");
        out.println();
        
        String[] post = root.postorder().split("\\s+");
        out.print("Postorder:");
        for (String s : post) out.print(s + " ");
        out.println();
    }
}

class Node {
    int val;
    Node left, mid, right;
    
    public Node(int x) {
        this.val = x;
        this.left = null;
        this.mid = null;
        this.right = null;
    }
    
    public String toString() {
        return Integer.toString(val);
    }
    
    public void add(int v) {
        if (this.val - v > 5) {
            if (this.left == null) left = new Node(v);
            else this.left.add(v);
        } else if (v - this.val > 5) {
            if (this.right == null) right = new Node(v);
            else this.right.add(v);
        } else {
            if (this.mid == null) mid = new Node(v);
            else this.mid.add(v);
        }
    }
    
    public String preorder() {
        String L = this.left == null ? "" : this.left.preorder();
        String M = this.mid == null ? "" : this.mid.preorder();
        String R = this.right == null ? "" : this.right.preorder();
        
        return String.format("%s %s %s %s", this.toString(), L, M, R);
    }
    
    public String postorder() {
        String L = this.left == null ? "" : this.left.postorder();
        String M = this.mid == null ? "" : this.mid.postorder();
        String R = this.right == null ? "" : this.right.postorder();
        
        return String.format("%s %s %s %s", L, M, R, this.toString());
    }
}