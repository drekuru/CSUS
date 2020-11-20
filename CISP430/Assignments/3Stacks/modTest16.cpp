#include <iostream>
#include <fstream>
using namespace std;

int main ()
{
	int input;
	cin>>input;
	int y = 16;
	int x[20];
	int i = 0;
	do 
	{
		x[i]=input%16;
		cout<<"This is input:"<<input<<endl;
		cout<<x[i];
		input=input/16;
		y = input+15;
		i++;
	}while(y/16 >= 1);
}
