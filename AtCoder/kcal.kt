//Problem: https://atcoder.jp/contests/abc205/tasks/abc205_a

fun main() {
  val (n, k) = readLine()!!.split(" ").map { it.toInt() }
  println(n * k / 100.0)
}
