// https://codeforces.com/contest/1713/problem/B

<?php
$cin = fopen("php://stdin", "r");
$cout = fopen("php://stdout", "w");

$t; $n; $arr;
fscanf($cin, "%d\n", $t);
for ($T = 0; $T < $t; $T++) {
    fscanf($cin, "%d\n", $n);
    $arr = explode(" ", trim(fgets($cin)));
    $p = [(int)$arr[0]];
    $prev = (int)$arr[0];
    for ($i = 1; $i < $n; $i++) {
        if ((int)$arr[$i] != $prev) {
            array_push($p, (int)$arr[$i]);
        }
        $prev = (int)$arr[$i];
    }
    $works = true;
    for ($i = 1; $i < count($p) - 1; $i++) {
        if ($p[$i-1] > $p[$i] and $p[$i] < $p[$i+1]) $works = false;
    }
    if ($works) fwrite($cout, "YES\n");
    else fwrite($cout, "NO\n");
} ?>