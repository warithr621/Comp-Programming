<?php
// https://codeforces.com/contest/1729/problem/A

$cin = fopen("php://stdin", "r"); // IO
$cout = fopen("php://stdout", "w"); // IO

$t;
fscanf($cin, "%d\n", $t);
for ($T = 0; $T < $t; $T++) {
	$a; $b; $c;
	fscanf($cin, "%d %d %d\n", $a, $b, $c);
	$first = abs($a - 1);
	$second = abs($b - $c) + abs($c - 1);
	if ($first == $second) {
		fprintf($cout, "3\n");
	} else if ($first > $second) {
		fprintf($cout, "2\n");
	} else {
		fprintf($cout, "1\n");
	}
} ?>