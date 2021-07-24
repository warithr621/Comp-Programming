//Problem: https://atcoder.jp/contests/abc211/tasks/abc211_b

package main

import (
    "fmt"
    "sort"
)

func main() {
    in := make([]string, 4)
    fmt.Scanf("%s\n%s\n%s\n%s", &in[0], &in[1], &in[2], &in[3])
    sort.Sort(sort.StringSlice(in))
    if in[0] == "2B" && in[1] == "3B" && in[2] == "H" && in[3] == "HR" {
        fmt.Println("Yes")
    } else {
        fmt.Println("No")
    }
}
