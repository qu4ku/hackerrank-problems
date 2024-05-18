// C

// https://www.hackerrank.com/challenges/jim-and-the-orders/
// dif: easy
// init 2024/05. done.

#include <stdio.h>
#include <math.h>
#include <stdlib.h>


typedef struct {
  int element[2];
  int index;
} ElementWithIndex;

int compareElements(const void* a, const void* b) {
  const ElementWithIndex* elem1 = (const ElementWithIndex*)a;
  const ElementWithIndex* elem2 = (const ElementWithIndex*)b;

  int sum1 = elem1->element[0] + elem1->element[1];
  int sum2 = elem2->element[0] + elem2->element[1];

  if (sum1 < sum2) {
    return -1;
  } else if (sum1 > sum2) {
    return 1;
  } else {
    return elem1->index - elem2->index;
  }
}

int main() {
  int n = 5;
  int arr[][2] = {{8, 1}, {4, 2}, {5, 6}, {3, 1}, {4, 3}};

  for(int i = 0; i < n; i++) {
    for(int j = 0; j < 2; j++) {
      printf("%d ", arr[i][j]);
    }
    printf("\n");
  }

  ElementWithIndex* elements = (ElementWithIndex*)malloc(n * sizeof(ElementWithIndex));
  for (int i = 0; i < n; i++) {
    elements[i].element[0] = arr[i][0];
    elements[i].element[1] = arr[i][1];
    elements[i].index = i + 1;
  }
  for (int i = 0; i < n; i++) {
    printf("index: %d, element: {%d, %d}\n", elements[i].index, elements[i].element[0], elements[i].element[1]);
  }
  printf("\n");

  qsort(elements, n, sizeof(ElementWithIndex), compareElements);

  for (int i = 0; i < n; i++) {
    printf("%d ", elements[i].index);
  }

  return 0;
}
