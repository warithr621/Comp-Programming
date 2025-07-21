//Problem: https://codeforces.com/contest/334/problem/A

package main

import "fmt"

func main() {
    var n int
    fmt.Scanf("%d", &n)
    n = n*n
    i := 1
    for i <= n/2 {
        fmt.Printf("%d %d\n", i, n-i+1)
        i++
    }
}
