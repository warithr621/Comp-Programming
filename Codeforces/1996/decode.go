// https://codeforces.com/contest/1996/problem/E

package main
import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

const MOD int64 = 1e9 + 7

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	scanner.Scan()
	T, _ := strconv.Atoi(scanner.Text())

	for t := 0; t < T; t++ {
		scanner.Scan()
		S := scanner.Text()
		N := len(S)
		freq := make(map[int64]int64)
		cur := int64(0)
		ans := int64(0)
		freq[0] = 1

		for i := 0; i < N; i++ {
			if S[i] == '1' {
				cur++
			} else {
				cur--
			}
			if val, found := freq[cur]; found {
				ans = (ans + val * int64(N-i) % MOD) % MOD
			}
			freq[cur] += int64(i + 2)
		}
		fmt.Fprintln(writer, ans)
	}
}
