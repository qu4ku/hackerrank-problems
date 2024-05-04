// C

// https://www.hackerrank.com/challenges/mark-and-toys/
// dif: easy
// init 2024/05. done.

#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
  return *(int*)a - *(int*)b;
}

int maximumToys(int n, int* prices, int k) {
  qsort(prices, n, sizeof(int), compare);

  int acc = 0;
  int sol = 0;

  for (int i = 0; i < n; i++) {
    if (acc + prices[i] <= k) {
      acc += prices[i];
      sol++;
    } else {
      break;
    }
  }

  return sol;
}

int main() {
  int k = 50;
  int prices[] = {1, 12, 5, 111, 200, 1000, 10};
  int n = sizeof(prices) / sizeof(prices[0]);

  int maxToys = maximumToys(n, prices, k);
  printf("%d", maxToys);

  return maxToys;
}
