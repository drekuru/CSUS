#include <iostream>
#include <fstream>
using namespace std;

void push(int item, struct node *&top);
struct node* build(int number);
void pop(struct node *&top);
struct node* build16(int number);
void pop16(struct node *&top2);

struct node 
{
int data;
struct node *next;
};

int main()
{
	int input = 0;
	cout<<"Please input an integer:"<<endl;
	cin>>input;
	node *top = new node;
	top->next=NULL;
	top= build(input);
	
	while(top->next)
	{
	pop(top);
	}
	
	cout<<"\n\nHEX"<<endl;
	node *top2 = new node;
	top2->next = NULL;
	top2=build16(input);
	while(top2->next)
	{
		pop16(top2);
	}
}

struct node* build(int number)
{
	node *nn = new node;
	int y =2;
	int bit;

	while(y/2>= 1)
	{
		bit = number%2;
		push(bit, nn);
		number = number/2;
		y = number+1;
	}
	return (nn);
}

void push(int item, struct node *&top){
    
	struct node *newNode=new node;
    newNode->data=item;
    newNode->next=top;
    top=newNode;
}

void pop(struct node *&top)
{
	struct node *temp;
	if(top!= NULL)
	{
		temp = top;
		if(top->next)
		{
		cout<<temp->data;
		top = top->next;
		}
		delete temp;
	}
	
}

struct node* build16(int number)
{
	node *nn = new node;
	int y = 16;
	int bit;
	
	while(y/16>=1)
	{
		bit = number%16;
		push(bit, nn);
		number = number/16;
		y = number+15;
	}
	return (nn);
}

void pop16(struct node *&top2)
{
	struct node *temp = new node;
	if(top2 != NULL)
	{
	temp = top2;
	if(top2->next)
	{
	switch(temp->data)
	{
	case 10:
		cout<<"A";
		break;
	case 11:
		cout<<"B";	
		break;
	case 12:
		cout<<"C";
		break;
	case 13:
		cout<<"D";
		break;
	case 14:
		cout<<"E";
		break;
	case 15:
		cout<<"F";
		break;
	default:
		cout<<temp->data;
		break;
	}
		top2 = top2->next;
	}
	delete temp;
}
}
