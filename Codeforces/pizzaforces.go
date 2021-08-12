//Problem: https://codeforces.com/contest/1555/problem/A

package main

import "fmt"

func main() {
   var t int
   var n int64
   fmt.Scan(&t)
   for i := 0; i < t; i++ {
       fmt.Scan(&n)
       if (n <= 6) {
           fmt.Println(15)
       } else {
           fmt.Println((n+1) / 2 * 5)
       }
   }
}
