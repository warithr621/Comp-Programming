// https://codeforces.com/contest/1547/problem/D

<?php
$cin = fopen("php://stdin", "r");
$cout = fopen("php://stdout", "w");

$t; $n; $arr;
fscanf($cin, "%d\n", $t);
for ($T = 0; $T < $t; $T++) {
    fscanf($cin, "%d\n", $n);
    $a = explode(" ", trim(fgets($cin)));
    $ans = [0 => 0];
    for ($i = 1; $i < $n; $i++) {
        array_push($ans, ($ans[$i-1] ^ (int)$a[$i-1]) & ~((int)$a[$i]));
    }
    for ($i = 0; $i < $n; $i++) {
        fwrite($cout, strval($ans[$i]) . " ");
    }
    fwrite($cout, "\n");
} ?>