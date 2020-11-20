#include <stdio.h>
#include <stdlib.h> 
#include<time.h> 

int main(void)
{
  srand(time(0)); // rand seed
  unsigned char data [ 10 ];

  printf("\nPrinting Left to Right\n");
  for(int i = 0; i<10; i++) 
  {
    data[i] = rand(); //set value
    if(data[i] < 10) //make sure it's over 10 according to assignment
    {
      data[i] += 10; 
    }
    printf("%d ",data[i]); //print it left to right
  } 

  printf("\n\nPrinting Right to Left\n");
  int x = 9;
  while(x >= 0) //print right to left
  {
    printf("%d ",data[x]);
    x--;
  }

  printf("\n\nFinding Largest Number\n");
  int MAX = 10;
  int index = 0;
  for(int i = 0; i <10; i++)
  {
    if(MAX < data[i])
    {
      index = i;
      MAX = data[i];
    }
  }
  printf("Largest Num: %d\nIndex: %d\n",MAX, index);

  printf("\n\nFinding Smallest Number\n");
  int MIN = 255;
  index = 0;
  for(int i = 0; i <10; i++)
  {
    if(MIN > data[i])
    {
      index = i;
      MIN = data[i];
    }
  }
  printf("Smallest Num: %d\nIndex: %d\n",MIN, index); 

  printf("\nSearching for Prime Numbers\n");
  for(int i = 0; i<10; i++)
  {
    int c;
    int n = data[i];

    if(n&1 || n&3)
    {
      for (c = 2; c <= n/2; c++)
      {
        if (n%c == 0)
        {
          //
          break;
        }
      }
    }

    if (c == n/2 + 1)
    printf("%d is prime.\n", n);
  }

}