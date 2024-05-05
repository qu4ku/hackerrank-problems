// C

// https://www.hackerrank.com/challenges/marcs-cakewalk/
// dif: easy
// init 2024/05. done.

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
  return (*(int*)b - *(int*)a);
}

int main() {
  int arr[] = {1, 3, 2};
  int n = sizeof(arr) / sizeof(arr[0]);
  int acc = 0;

  qsort(arr, n, sizeof(int), compare);

  for (int i=0; i < n; i++) {
    acc += arr[i] * (int)pow(2, i);
  }

  printf("%d\n", acc);

  return 0;
}
