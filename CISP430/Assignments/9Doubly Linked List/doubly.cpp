#include <iostream>
#include <fstream>
using namespace std;



void deleting(struct node *&head, struct node *&tail, int input);
void deletingB(struct node *&head, struct node *&tail, int input);
void traverse(struct node *&head, struct node *&tail);

ifstream in("input.txt");

struct node
{
	int data;
	struct node *next;
	struct node *prev;	
};

int main ()
{
	int a;
	node *head, *tail;
	head = tail = NULL;
	while(in>>a)
	{
		node *nn = new node;
		nn->data=a;
		nn->next = nn->prev = NULL;
		if(head == NULL)
		{
			cout<<"Adding to head"<<a<<endl;
			head=tail=nn;
			head->next=head->prev=NULL;
		}
		else if (head->next == NULL)
		{
			cout<<"Adding after head: "<<a<<endl;
			nn->prev = head;
			head->next = nn;
			nn->next = NULL;
			tail = nn;
			tail->next = NULL;
		}
		else
		{
			cout<<"Adding to end"<<a<<endl;
			nn->prev=tail;
			nn->next=NULL;
			tail->next=nn;
			tail = nn;
		}
	}
	
	cout<<"Enter a number ";
	int input;
	cin>>input;
	cout<<"Delete "<<input<<" element from the front"<<endl;
	deleting(head, tail, input);
	traverse(head,tail);
	
	cout<<"Enter a number to delete backwards";
	cin>>input;
	deletingB(head,tail,input);
	traverse(head,tail);
}

void traverse(struct node *&head, struct node *&tail)
{
	node *cur = new node;
	cur = head;
	while(cur != NULL)
	{
		cout<<cur->data<<endl;
		cur=cur->next;	
	}	
}

void deleting(struct node *&head, struct node *&tail, int input)
{
	node *cur = new node;
	cur = head;
	
	if(input == 1)
	{
		cout<<"Going to delete number "<<cur->data<<endl;
		head=head->next;
		head->next->prev=NULL;		
	}
	else 
	{
	for(int i = 1; i<input; i++)
	{cur = cur->next;}
		if(cur==tail)
		{
		cout<<"Going to delete number "<<cur->data<<endl;
		tail=tail->prev;
		tail->next = NULL;
		}
		else
		{
		cout<<"Going to delete number "<<cur->data<<endl;
		cur->prev->next = cur->next;
		cur->next->prev = cur->prev;
		}
	cout<<"Done"<<endl;
	}
	
}

void deletingB(struct node *&head, struct node *&tail, int input)
{
	node *cur = new node;
	tail->next = NULL;
	cur = tail;
	
	if(input == 1)
	{
		cout<<"Going to delete number "<<tail->data<<endl;
		tail = tail->prev;
		tail->next = NULL;
	
	}
	else
	{
		for(int i = 1; i<input; i++)
		{cur = cur->prev;}
	
		if(cur == head)
		{
			cout<<"Going to delete number "<<cur->data<<endl;
			head = head->next;
			head->prev=NULL;
		}
		else
		{
		cout<<"Going to delete number "<<cur->data<<endl;
		cur->prev->next = cur->next;
		cur->next->prev = cur->prev;
		}
	}
	cout<<"Done"<<endl;
}
