#include <stdio.h>
#include <stdbool.h>

int main(void) // I Did capital letters only because instructions were not clear.
{
  int num = 0;
  int shifter = 0;
  int sub = 65;

  char c;
  printf("Please enter password\n:");
  while(num != 67108863)
  {
    c = getchar();
    if(c == '\n')
    break;

    switch(c)
    {
      case'A'...'Z':
        //printf("%c\n", c);
        c = c - sub;
        shifter = 1 << c;
        num = num | shifter;
        //printf("%d %d\n",num, shifter);
        shifter = 0;
        break;
      default:
        break;
    }
    

    

  }
  if(num == 67108863)
    {
      printf("Your string is a Pangram");
    }
    else
    {
      printf("Your string is not pangram");
    }
}