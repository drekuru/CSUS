#include <iostream>
using namespace std;
void commaInsert(int v, int &count)
{
	if (v <= 0) 
	{
		count--;
		return ; //base case
	}
	count++;
	commaInsert(v/1000, count);
	cout<<(v%1000)<<((count--)?",":" ");
	return;
}
int main()
{
	int input = 0;
	cout<<"Input num: ";
	cin>>input;
	int count = 0;
	commaInsert(input, count);
	cout<<endl;
	return 0;
}
