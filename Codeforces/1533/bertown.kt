//Problem: https://codeforces.com/contest/1533/problem/A

fun main() = repeat(readLine()!!.toInt()) {
  val (n, k) = readLine()!!.split(" ").map { it.toInt() }
  var ans = 0
  repeat(n) {
    val (l, r) = readLine()!!.split(" ").map { it.toInt() }
    if (l <= k) ans = maxOf(ans, r - k + 1)
  }
  println(ans)
}
