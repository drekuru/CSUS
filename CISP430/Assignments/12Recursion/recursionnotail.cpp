#include <iostream>
using namespace std;

int sum_of_digit(int n);

int main()  
{
int num = 0;
cout<<"Enter a Number: ";
cin>>num; 
int result = sum_of_digit(num);
printf("Sum of digits in %d is %d\n", num, result);
return 0;
}

int sum_of_digit(int n)  
{      
if (n == 0)         
	return 0;
else   
	return (n % 10 + sum_of_digit(n / 10));
}


