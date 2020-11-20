#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

struct _questions
{
  char  question[1000];
  char  opt1    [1000];
  char  opt2    [1000];
  char  opt3    [1000];
  char  opt4    [1000];
  unsigned char correct;
};

void readAllQuestions(struct _questions *qBank) 
{
  FILE * fp;
  fp = fopen("questionbank.txt", "r");
  if(fp == NULL)
  {
    printf("Couldn't open file");
  }
  else //continues if no errors
  {
    for(int i = 0; i < 50; i++)
    {
      //printf("%d     ",i);
      fgets(qBank[i].question,128,fp);
      //printf("%s\n" ,qBank[i].question);

      fgets(qBank[i].opt1,128,fp);
      fgets(qBank[i].opt2,128,fp);
      fgets(qBank[i].opt3,128,fp);
      fgets(qBank[i].opt4,128,fp);
      char temp [12];
      fgets(temp,128,fp);
      qBank[i].correct = temp[0];
      //printf("This is Temp %c",temp[0]);
    }
  }

   fclose(fp);
}

void displayQuestion(struct _questions *ptr  ,   unsigned char qNum)
{
  printf("%s", ptr->question);
  printf("%s", ptr->opt1);
  printf("%s", ptr->opt2);
  printf("%s", ptr->opt3);
  printf("%s", ptr->opt4);
}

void updateTheScore(int *score, unsigned char cAnswer, unsigned char userAnswer )
{
  if(userAnswer == cAnswer)
  {
    *score = *score + 1;
    printf("Correct. Your current score is : %d\n",*score);
  }
  else
    printf("Sorry\n The Correct Answer is: %c\n",cAnswer);
}

int main(void)
{
  srand(time(NULL));
  int randQ = rand()%50;
  struct _questions  qBank[50];
  readAllQuestions(qBank);
  
  int score = 0;

  for(int i = 0; i<5; i++)
  {
    unsigned char userResponse;
    displayQuestion(&qBank[randQ],randQ);
    printf ( "\nPlease enter the correct answer 1, 2, 3 or 4 and press enter \n");
    scanf ( "%c", &userResponse);
    if (userResponse == '\n')
        {
            scanf("%c", &userResponse);
        }
    updateTheScore(&score,qBank[randQ].correct,userResponse);
    randQ = rand()%50;

  }
  printf("Thank You For Playing:)");
}