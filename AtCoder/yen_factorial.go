//Problem: https://atcoder.jp/contests/abc208/tasks/abc208_b

package main

import "fmt"

func main() {
    var p int
    fmt.Scanf("%d %d", &p);
    fact := [10]int{1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800}
    ans := 0
    track := 9
    for p > 0 {
        if p >= fact[track] {
            p -= fact[track]
            ans++
        } else {
            track--
        }
    }
    fmt.Println(ans)
}
