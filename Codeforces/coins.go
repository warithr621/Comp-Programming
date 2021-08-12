//Problem: https://codeforces.com/problemset/problem/1061/A

package main

import "fmt"

func main() {
    var a int
    var b int
    fmt.Scanf("%d %d", &a, &b);
    fmt.Println((b + a - 1) / a);
}
