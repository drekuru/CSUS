#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
  FILE * fp;
  
  int year = 0;
  float income = 0;

  while (year != 2018 && year != 2019)
  {
      printf("Please enter your tax year: 2018 or 2019 \n");
      scanf("%d", &year);
  }

  do
  {
      printf("Please enter you income: Value from 0 to 100000 \n");
      scanf("%f", &income);
  } while (income < 0 || income > 100000);

  if(year == 2018)
  {
    fp = fopen( "2018.txt", "r" );
  }
  else
  {
    fp = fopen( "2019.txt", "r" );
  }

  if(fp == NULL)
  {
    printf("Couldn't open file");
  }
  else //continues if no errors
  {
    float bracket[5] = {0};
    float rate[5] = {0};
    
    for(int i = 0; i < 4; i++)
    {
      fscanf(fp, "%f %f", &rate[i], &bracket[i]);  
      rate[i] = rate[i] * .01;
      //printf("%0.2f\n",rate[i]);
    }

    // calculate TIERS
    float tax = 0;
    float TIER_1 = bracket[0] * rate[0];
    float TIER_2 = (bracket[1] - bracket[0]) * rate[1];
    float TIER_3 = (bracket[2] - bracket[1]) * rate[2];

    if (income < bracket[0])
    {
        tax = income * rate[0];
        printf("%0.2f", tax);
    }
    else if (income >= bracket[0] && income < bracket[1])
    {
        tax = TIER_1 + rate[1] * (income - bracket[0]);
        printf("%0.2f", tax);
    }
    else if (income >= bracket[1] && income < bracket[2])
    {
        tax = TIER_1 + TIER_2 + (rate[2] * (income - bracket[1]));
        printf("%0.2f", tax);
    }
    else if (income >= bracket[2] && income < bracket[4])
    {
        tax = TIER_1 + TIER_2 + TIER_3 + rate[3] * (income - bracket[2]);
        printf("%0.2f", tax);
    }

    
  }
 


   fclose(fp);
}