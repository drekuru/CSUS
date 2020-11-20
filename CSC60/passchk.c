#include <stdio.h>
#include <stdbool.h>

int main(void)
{
    bool upper = false, lower = false, digit = false, special = false;
    bool flags = upper && lower && digit && special;
    char c;
    printf("Please enter password\n:");
    while (flags == false)
    {
        c = getchar();
        printf("%c", c);
        switch (c)
        {
        case 'A' ... 'Z':
            upper = true;
            break;
        case '0' ... '9':
            digit = true;
            break;
        case 'a' ... 'z':
            lower = true;
            break;
        case '#':
            special = true;
            break;
        case '%':
            special = true;
            break;
        case '+':
            special = true;
            break;
        default:
            break;
        } // end of switch

        flags = upper && lower && digit && special;

        if (c == '\n' && flags == false)
        {
            printf("Please enter a password that meets all requirements!\n");
            upper = lower = digit = special = false;
        }

    } //end of while loop

    printf("Good Password");
}