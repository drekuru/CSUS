#include <stdio.h>
#include <math.h>

int main()
{
    int num = 0; // initialize
    printf("Please enter a number between 0 and 255\n:");
    scanf("%d", &num); //input number

    int bin[8]; // set array size
    int i = 7;  // set counter

    while (i >= 0) // loop until -1
    {
        bin[i] = num % 2; // store mod
        num = num / 2;    // decrement num
        i--;              //counter track
    }

    printf("This is binary num: ");
    for (int x = 0; x < 8; x++) // for each int in array
    {
        printf("%d", bin[x]); // print
    }
    printf("\n");
}
