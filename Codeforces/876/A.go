//Problem: https://codeforces.com/contest/876/problem/A

package main

import "fmt"

func min(a, b int) int {
    if a < b {
        return a;
    }
    return b;
}

func main() {
    var n int
    var a int
    var b int
    var c int
    fmt.Scanln(&n); fmt.Scanln(&a); fmt.Scanln(&b); fmt.Scanln(&c);
    ans := min(a, b);
    if (n == 1 || !(c < a && c < b)) {
        fmt.Println(ans * (n-1));
    } else {
        fmt.Println(ans + c * (n-2));
    }
}
