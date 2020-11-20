#include <iostream>
using namespace std;

struct node *split (struct node *&head);
struct node *merge(struct node *&a, node *&b);
struct node *mergeSort(struct node *&head);
void traverse(struct node *&head, struct node *&tail);
void insert(struct node *&head, struct node *&tail, int data);


struct node
{
	int data;
	struct node *next;
	struct node *prev;	
};

int main ()
{
	int arr [7] = {6213,44,-51,3,12,2,7};
	node *head = new node;
	node *tail = new node;
	head = head->prev= tail->next = NULL;
	
	for(int i = 0; i<7;i++ )
	{
		insert(head,tail,arr[i]);
	}
	cout<<"Done\n";
	
	traverse(head,tail);
	cout<<"Sorting...\n";
	
	head=mergeSort(head);
	traverse(head,tail);

}

struct node *split(struct node *&head)
{
	node *big = head, *small = head;
	while(big->next && big->next->next)
	{
		big = big->next->next;
		small = small->next;
	}
	node *temp = small->next;
	small->next = NULL; //Why?
	
	return temp;
}

struct node *merge(struct node *&a, node *&b)
{
	if (!a)
	return b;
	if (!b)
	return a;
	
	if(a->data < b->data)
	{
		a->next = merge(a->next,b);
		a->next->prev = a;
		a->prev = NULL;
		return a;
	}
	else
	{
		b->next=merge(a,b->next);
		b->next->prev = b;
		b->prev = NULL;
		return b;
	}
}

struct node *mergeSort(struct node *&head)
{
	if(head == NULL || head->next == NULL)
		return head;
		
	node *nn = split(head);
	
	head = mergeSort(head);
	nn = mergeSort(nn);
	
	return merge(head,nn);
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

void insert(struct node *&head, struct node *&tail, int data) 
{ 
	node *temp = new node;
    temp->data = data;
    temp->next = temp->prev = NULL; 
    if(!head)
    {
    	head = tail = temp;
    	head->next=tail->prev= NULL;	
	}
	else if(head->next == NULL)
	{
		temp->prev = head;
		head->next = temp;
		tail = temp;
	}
	else
	{
		temp->prev = tail;
		tail->next = temp;
		tail = temp;
	}
}
