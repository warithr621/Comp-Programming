// https://codeforces.com/contest/1713/problem/A

<?php $t = (int)readline();
for ($T = 0; $T < $t; $T++) {
    $n = (int)readline();
    $ymx = 0;
    $ymn = 0;
    $xmx = 0;
    $xmn = 0;
    for ($i = 0; $i < $n; $i++) {
        $point = explode(" ", readline());
        $curx = (int)$point[0];
        $cury = (int)$point[1];
        if ($curx == 0) {
            $ymn = min($ymn, $cury);
            $ymx = max($ymx, $cury);
        } else {
            $xmn = min($xmn, $curx);
            $xmx = max($xmx, $curx);
        }
    }
    echo 2 * ($ymx - $ymn + $xmx - $xmn);
    echo "\n";
} ?>