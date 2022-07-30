//2021 Jan Bronze P3

#include <stdio.h>

void swap(long long int* x, long long int* y) {
    long long int temp = *x;
    *x = *y;
    *y = temp;
}

void sort(long long int arr[], int n) {
    //I later learned qsort exists, but I'm just going to go with it
    int i, j, mn;
    for (int i = 0; i < n-1; i++) {
        mn = i;
        for (int j = i+1; j < n; j++) {
            if (arr[j] < arr[mn]) mn = j;
        }
        swap(&arr[mn], &arr[i]);
    }
}

int main() {
    int n;
    scanf("%d", &n);
    long long int a[n], b[n];
    for (int i = 0; i < n; i++) scanf("%lld", &a[i]);
    for (int i = 0; i < n; i++) scanf("%lld", &b[i]);
    sort(a, n);
    for (int i = 0; i < n/2; i++) swap(&a[i], &a[n-i-1]);
    
    long long int ans = 1;
    for (int i = 0; i < n; i++) {
        long long int cnt = -1 * i;
        for (int j = 0; j < n; j++) {
            if (a[i] <= b[j]) ++cnt;
        }
        ans *= cnt;
    }
    printf("%lld", ans);
}
