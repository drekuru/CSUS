#include <stdio.h>
#include <math.h>


#define TIER_1 floor(.10 * (9525))
#define TIER_2 floor(0.12 * (38700 - 9525))
#define TIER_3 floor(0.22 * (82500 - 38701))

int main()
{
    float amount = 0;
    printf("Please enter amount earned: from 0 to 100000\n:");
    scanf("%f", &amount);

    float tax = 0;

    if (amount < 9525)
    {
        tax = amount * .10;
        printf("%0.2f", tax);
    }
    else if (amount >= 9525 && amount < 38700)
    {
        tax = TIER_1 + .12 * (amount - 9525);
        printf("%0.2f", tax);
    }
    else if (amount >= 38700 && amount < 82500)
    {
        tax = TIER_1 + TIER_2 + (.22 * (amount - 38700));
        printf("%0.2f", tax);
    }
    else if (amount >= 82500 && amount < 100000)
    {
        tax = TIER_1 + TIER_2 + TIER_3 + .24 * (amount - 82500);
        printf("%0.2f", tax);
    }
    else
    {
        printf("Enter a valid number");
    }
}