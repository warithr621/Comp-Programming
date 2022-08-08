// https://codeforces.com/contest/868/problem/B

<?php
$cin = fopen("php://stdin", "r");
$cout = fopen("php://stdout", "w");

$h; $m; $s; $t1; $t2;
fscanf($cin, "%d %d %d %d %d", $h, $m, $s, $t1, $t2);

//step 1: locate the pos of each hand
//step 2: pretend we're checking the short way from $t1 to $t2
    //if the hour hand falls on it, set 'a' to true otherwise false
        //likewise for minute ('b') and second ('c')
    //if 'a' 'b' 'c' are ALL the same value, the answer is YES (you can just go the other way)
    
//convert everything to degrees 
$t1 = $t1 * 30; $t2 = $t2 * 30; //30 <= t1, t2 <= 360
$second_pos = $s * 6; // 0 <= s <= 354
$minute_pos = $m * 6 + $s / 10.0; // 0 <= m <= 359.9
$hour_pos = $h * 30 + $m / 2.0 + $s / 120.0; // 0 <= h <= 359.991666...

//we're gonna try going clockwise from t1 to t2
if ($t2 < $t1) $t2 += 360;
if ($second_pos < $t1) $second_pos += 360;
if ($minute_pos < $t1) $minute_pos += 360;
if ($hour_pos < $t1) $hour_pos += 360;
$a = false; $b = false; $c = false;
if ($t1 < $second_pos and $second_pos < $t2) $a = true;
if ($t1 < $minute_pos and $minute_pos < $t2) $b = true;
if ($t1 < $hour_pos and $hour_pos < $t2) $c = true;

if ($a == $b and $b == $c) fwrite($cout, "YES\n");
else fwrite($cout, "NO\n");
?>