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
void pop(struct node *&top);


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
			enqueue(front,rear,a[i]);
		}
		else
		{
			if(a[i] == "s")
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
    newNode->next=top;
    top=newNode;
}

void pop(struct node *&top)
{
    while (top != NULL)
    {
        node *temp;
        if(top){
            temp=top;
            top=top->next;
            delete temp;
        }
    }
}
