#include <iostream>
#include <fstream>
using namespace std;

int main ()
{
	int input;
	cin>>input;
	int y = 2;
	int x[20];
	int i = 0;
	do 
	{
		x[i]=input%2;
		cout<<"This is input:"<<input<<endl;
		cout<<x[i];
		input=input/2;
		y = input+1;
		i++;
	}while(y/2 >= 1);
}
