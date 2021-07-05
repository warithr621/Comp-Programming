//Problem: https://atcoder.jp/contests/abc208/tasks/abc208_a

package main

import "fmt"

func main() {
    var a int
    var b int
    fmt.Scanf("%d %d", &a, &b);
    if (a <= b && 6*a >= b) {
        fmt.Println("Yes");
    } else {
        fmt.Println("No");
    }
}
