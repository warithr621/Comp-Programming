//Problem: https://atcoder.jp/contests/abc211/tasks/abc211_a

package main

import "fmt"

func main() {
   var a float64
   var b float64
   fmt.Scanf("%f %f", &a, &b)
   fmt.Println((a - b) / 3.0 + b)
}
