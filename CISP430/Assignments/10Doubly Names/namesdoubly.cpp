#include <iostream>
#include <fstream>
#include <string>
using namespace std;


void traverse(struct node *&head, struct node *&tail);
void deleteString(struct node *&head, struct node *&tail, string input);
void traverseBack (struct node *&head, struct node *&tail);


ifstream in("input.txt");

struct node
{
	string data;
	struct node *next;
	struct node *prev;	
};


int main ()
{
	string a;
	node *head, *tail;
	head = tail = NULL;
	while(in>>a)
	{
		node *nn = new node;
		nn->data=a;
		//cout<<"Current Name: "<<a<<endl;
		nn->next = nn->prev = NULL;
		
		if(head == NULL)
		{
			//cout<<"Adding to head: "<<a<<endl;
			head=tail=nn;
			head->next=head->prev=NULL;
		}
		
		else if (a.compare("delete")==0)
		{
			in>>a;
			deleteString(head,tail,a);
		}
		else if(a.compare(head->data)<0)
		{
			//cout<<"Adding before head: "<<a<<endl;
			nn->next=head;
			head->prev = nn;
			nn->prev = NULL;
			head = nn;
		}
		else if (a.compare(head->data)>0)
		{
			node *cur = new node;
			cur = head;
			while(cur->next != NULL && a.compare(cur->data)>0)
			{
				cur = cur->next;
			}
				if(cur->next != NULL && a.compare(cur->data)>0)
				{
				cur->prev->next=nn;
				nn->next = cur;
				nn->prev = cur->prev;
				//cout<<"Adding after head: "<<a<<endl;
				}
				if(cur->next != NULL && a.compare(cur->data)<0)
				{
				nn->next = cur;
				cur->prev->next=nn;
				nn->prev = cur->prev;
				cur->prev = nn;
				//cout<<"Adding after head: "<<a<<endl;
				}
				if(cur==tail)
				{
					//cout<<"Adding to tail: "<<a<<endl;
					nn->prev=tail;
					nn->next=NULL;
					tail->next=nn;
					tail = nn;
				}
			
		}
	}//end of while loop
	cout<<"Traversing\n"<<endl;
	traverse(head,tail);
	cout<<"\n===== ===== ===== =====\n\n";
	traverseBack(head,tail);
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

void traverseBack (struct node *&head, struct node *&tail)
{
	node *cur = new node;
	cur = tail;
	while (cur!= NULL)
	{
		cout<<cur->data<<endl;
		cur = cur->prev;
	}
}

void deleteString(struct node *&head, struct node *&tail, string input)
{
	node *cur = new node;
	cur = head;
	while (cur->next !=NULL && input.compare(cur->data)!= 0)
	{cur = cur->next;}
	if(input.compare(cur->data)==0)
	{
		cout<<"Deleting.."<<cur->data<<endl;
		if(cur == head)
		{
			head=head->next;
			head->next->prev=NULL;
		}
		else if (cur == tail)
		{
			tail=tail->prev;
			tail->next = NULL;
		}
		else
		{
		cur->prev->next = cur->next;
		cur->next->prev = cur->prev;
		}
	}//end of if
	
}
