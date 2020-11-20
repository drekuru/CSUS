// why do we push the last parameter first?
// why does the first parameter has the lowest addr compared to all other params
#include <stdint.h>
int sumUntilZero(int x,...)
{
  int *p;
  int s;

  p = &x;
  s = 0;
  while (*p)
  {
    s += *p;
    ++p;
  }
  return s;
}

int main()
{
  int k;

  k = sumUntilZero((int)1,(int)2,(int)3,(int)0,(int)4,(int)5);
  return 0;
}