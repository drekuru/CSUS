#include <stdio.h>

int main(void)
{
  unsigned char data[10] = {21, 42, 63, 81, 72, 61, 53, 59, 39, 32};
  unsigned char *ptr;

  ptr = data;
  int i = 0;
  printf("\nPrinting In Order...\n");
  for (i = 0; i < 10; i++)
  {
    printf("%d ", *ptr);
    ptr++;
  }

  ptr = data + 9;
  printf("\n\nPrinting In Reverse...\n");
  for (i = 10; i > 0; i--)
  {
    printf("%d ", *ptr);
    ptr--;
  }

  ptr = data;
  int temp = 0, index = 0;
  printf("\n\nFinding MAX...\n");
  for (i = 0; i < 10; i++)
  {
    if (*ptr >= temp)
    {
      temp = *ptr;
      index = i;
    }
    ptr++;
  }
  printf("Max VALUE: %d ", temp);
  printf("Index of MAX: %d\n", index);

  ptr = data;
  printf("\nFinding MIN... \n");
  for (i = 0; i < 10; i++)
  {
    if (*ptr <= temp)
    {
      temp = *ptr;
      index = i;
    }
    ptr++;
  }
  printf("Min VALUE: %d ", temp);
  printf("Index of MIN: %d\n", index);

  unsigned int iData[] = {0xf0f1f3f4, 0xf5f6f7f8, 0xf9fAfBfC};
  ptr = iData;
  printf("\nPrinting Byte Values... Out of Order\n");
  for (i = 0; i < 12; i++)
  {
    //printf("%d\n", iData[i]);
    printf("%d\n", *ptr);
    ptr++;
  }

  printf("\n");
}