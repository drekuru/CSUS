#include <stdio.h>
#include <string.h>

int main(void) {
  
  char name[32],  address[32], city[32], state[3], zip[6], data[256];

  printf("ENTER YOUR NAME: ");
  scanf("%s", name);

  strcpy(address, "5000 Washington Blvd");
  strcpy(city, "Sacramento");
  strcpy(state, "CA");
  strcpy(zip, "95682");

  strcpy(data, name);
  strncat(data, "\n", 1);

  strcat(data, address);
  strncat(data, "\n", 1);

  strcat(data, city);
  strncat(data, "\n", 1);

  strcat(data, state);
  strncat(data, "\n", 1);

  strcat(data, zip);
  strncat(data, "\n", 1);

  int i = 0;
  int counter = 0;
  while(i < strlen(data))
  {
    if(data[i] == '\n' || i == 0)
    {
      //printf("\n");
      switch(counter)
      {
        case 0:
          printf("\nName: ");
          break;
        case 1:
          printf("\nAddress: ");
          break;
        case 2:
          printf("\nCity: ");
          break;
        case 3:
          printf("\nState: ");
          break;
        case 4:
          printf("\nZip: ");
          break;
      }
      counter++;
    }
    if(data[i] != '\n')
    {
      printf("%c",data[i]);
    }
    i++;
  }


  




  return 0;
}