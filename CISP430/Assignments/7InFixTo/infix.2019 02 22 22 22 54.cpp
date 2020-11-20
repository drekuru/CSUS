#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
using namespace std;

void enqueue(struct node *&front, struct node *&rear, char input);
void dequeue(struct node *&front, struct node *&rear);
void traverse(struct node *&front, struct node *&rear);
void push(struct node *&top, char input);
void pop(struct node *&top, struct node *&front, struct node *&rear);


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
	
	int prevVal = 0;
	int curVal = 0;
	for(int i=0; a[i]!= NULL; i++)
	{
		if (isdigit(a[i]))
		{
			enqueue(front,rear,a[i]);
		}
		else
		{
			string q;
			q = a[i];
			if(q == "(")
			{
					push(top, a[i]);
			}
		}
	}
}

void enqueue(struct node *&front,struct node *&rear, char input)
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

void push(struct node *&top, char input)
{
    node *newNode=new node;
    newNode->data=input;
    string q;
    q = input;
    	if(q == "(")
			newNode->value = 0;
		if(q == ")")
			newNode->value = 0;
		if(q == "+")
			newNode->value = 1;
		if(q == "-")
			newNode->value = 1;
		if(q == "/")
			newNode->value = 2;
		if(q == "*")
			newNode->value = 2;
    newNode->next=top;
    top=newNode;
}

void pop(struct node *&top, struct node *&front, struct node *&rear)
{
    while (top != NULL)
    {
        node *temp;
        if(top){
            temp=top;
            top=top->next;
            if(temp->data ==)
            enqueue(front, rear, temp->data);
            delete temp;
        }
    }
}
