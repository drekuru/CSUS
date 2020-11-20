#include <iostream>
#include <fstream>
using namespace std;

void enqueue(struct node *&front, struct node *&rear, int input);
void dequeue(struct node *&front, struct node *&rear);
void traverse(struct node *&front, struct node *&rear);
bool traverseCheck(struct node *&front, struct node *&rear);
void Readfile(struct node *&front, struct node *&rear);
void filter(struct node *&front, struct node *&rear);

ifstream in("input.txt");

struct node
{
	int data;
	struct node *next;
};


int main ()
{
	node *front, *rear;
	front = rear = NULL;
	Readfile(front,rear);
	cout<<"Before Filter\n";
	traverse(front, rear);
	filter(front, rear);
	cout<<"\nAfter Filter\n";
	traverse(front, rear);
		
	
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

void traverse(struct node *&front, struct node *&rear)
{
	node *temp = new node;
	temp = front;
	while(temp)
	{
	cout<<temp->data<<endl;
	temp = temp->next;
	}	
	cout<<"End of Queue"<<endl;
}

void Readfile(struct node *&front, struct node *&rear)
{
	int a;
	while(in>>a)
	{
		enqueue(front, rear,a);
	}
}

void filter(struct node *&front, struct node *&rear)
{
	int x = front->data;
	while(traverseCheck(front,rear) != true)
	{
		if(front->data > 0)
		{enqueue(front, rear, front->data);}
		dequeue(front,rear);
	}
	
	while (front->data != x)
	{
		enqueue(front,rear,front->data);
		dequeue(front,rear);
	}	
	
}

bool traverseCheck(struct node *&front, struct node *&rear)
{
	node *temp = new node;
	temp = front;
	bool var = true;
	while(temp)
	{
	if(temp->data < 0)
	{
		var = false;
		break;
	}
	temp = temp->next;
	}
	return var;
}
