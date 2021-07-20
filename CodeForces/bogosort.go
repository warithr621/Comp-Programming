//Problem: https://codeforces.com/contest/1312/problem/B

package main
import (
	"fmt"
	"sort"
)
func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++{
		var n int
		fmt.Scan(&n)
		a := make([]int, n)
		for j := 0; j < n; j++{
			fmt.Scan(&a[j])
		}
		sort.Sort(sort.Reverse(sort.IntSlice(a)))
		for k := 0; k < len(a); k++{
			fmt.Print(a[k], " ")
		}
		fmt.Println()
	}
}
