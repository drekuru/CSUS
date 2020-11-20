#include <iostream>
#include <fstream>
using namespace std;

void stringCopy(char *A, char *B);
bool stringCompare(char *A, char *B);
void stringConcatenation (char *A, char *B);
int stringPosition(char *A, char B);
int stringLength(char *A);

ifstream in("input.txt");
int main(){
	
	char a[20],b[20],a2[20],b2[20],a3[20],b3[20],a4[20],a5[10];
	char b4;
	in>>a>>b>>a2>>b2>>a3>>b3>>a4>>b4>>a5;
	in.close();

	cout<<"Before Func1:"<<a<<endl;
	stringCopy(a, b);
	cout<<"After Func1:"<<a<<endl;
	
	cout<<"\nBool in Func2 is:"<<stringCompare(a2, b2)<<endl;
	
	cout<<"\nBefore Func3:"<<a3<<" and "<<b3<<endl;
	stringConcatenation(a3, b3);
	cout<<"After Func3: "<<a3<<" ...displaying only a3"<<endl;
	
	cout<<"\nFunc4 returning int: "<<stringPosition(a4, b4)<<endl;
	
	cout<<"\nFunc 5.."<<endl;
	cout<<"String Length is: "<<stringLength(a5)<<endl;
	cout<<"New Array:"<<a5;
	
}

void stringCopy(char *A, char *B)
{
	for(int i = 0;i<20; ++i)
	{
		A[i]=B[i];
	}
}

bool stringCompare(char *A, char *B)
{
	int i = 0;
	bool var = true;
	while (A[i] != NULL)	
	{
		if(A[i]!=B[i])
		{
			var = false;
			break;
		}
		
		else{i++;}
	}
	return var;
}

void stringConcatenation (char *A, char *B)
{
	int i = 0;
	while(A[i]!= NULL){i++;}
	int j = 0;
	while(B[j]!= NULL)
		{A[i]=B[j];
		i++;
		j++;}
	
}

int stringPosition(char *A, char B)
{
	int i = 0;
	int j = -1;
	//cout<<A<<B;
	while(A[i] != NULL)
	{
		if(A[i] == B)
		{
			j = i;
			break;
		}
		i++;
	}
	return j;
}

int stringLength(char *A)
{
	char C[10];
	int i = 0;
	while(A[i] != NULL)
	{
		C[i]=A[i];
		i++;
		
	}
	A[0] = i;
	i = 1;
	int j = 0;
	while (C[j] != NULL)
	{
		A[i] = C[j];
		j++;
		i++;
	}
	A[8] = NULL ; // If i dont have this statem ent random characters from the ASCII table start popping up
				  //It's weird and i didn't see any other solution :)

	return A[0];
}







