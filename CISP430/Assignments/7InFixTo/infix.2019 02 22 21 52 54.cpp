#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
using namespace std;

void enqueue(struct node *&front, struct node *&rear, int input);
void dequeue(struct node *&front, struct node *&rear);
void traverse(struct node *&front, struct node *&rear);


ifstream in("input.txt");

struct node
{
	char data;
	int value;
	struct node *next;
};

int main()
{
	node *top = new node;
	top->next=NULL;
	node *front, *rear;
	front = rear = NULL;
	char a[20];
	in>>a;
	cout<<a;
	
	for(int i=0; a[i]!= NULL; i++)
	{
		if (isdigit(a[i]))
		{
			cout<<a
			enqueue(front,rear,a[i]);
		}
	}
}

void enqueue(struct node *&front,struct node *&rear, int input)
{
	node *nn = new node;
	nn->data=input;
	nn->next=NULL;
	
	if (!front)
	{
		rear = front = nn;
	}
	else
	{
		rear->next=nn;
		rear=nn;
	}
}

void dequeue(struct node *&front,struct node *&rear)
{
	
	node *temp = new node;
	temp->next = NULL;
	if(front)
	{
		temp = front;
		front = front->next;
		delete temp;
	}
	if(!front)
	{
		rear = NULL;
	}
}
