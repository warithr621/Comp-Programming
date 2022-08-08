// https://codeforces.com/contest/868/problem/A

<?php
$cin = fopen("php://stdin", "r");
$cout = fopen("php://stdout", "w");

$pass; $n;
fscanf($cin, "%s", $pass); fscanf($cin, "%d", $n);
$arr = [];
for ($i = 0; $i < $n; $i++) {
    $a; fscanf($cin, "%s\n", $a);
    array_push($arr, $a);
}
$b = false;
for ($i = 0; $i < $n; $i++) {
    for ($j = 0; $j < $n; $j++) {
        if ($arr[$i] == $pass or $arr[$j] == $pass) $b = true;
        if ($arr[$i][1] == $pass[0] and $arr[$j][0] == $pass[1]) $b = true;
        if ($arr[$i][0] == $pass[1] and $arr[$j][1] == $pass[0]) $b = true;
    }
}
if ($b) fwrite($cout, "YES\n");
else fwrite($cout, "NO\n");
?>