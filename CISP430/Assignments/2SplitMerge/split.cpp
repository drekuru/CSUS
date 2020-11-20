#include <iostream>
#include <fstream>
using namespace std;

void Traverse(struct node *head);
struct node* Readfile();
void Traverse(struct node* head);
void Split(struct node* head);
int Length (struct node* head);

struct node* Merge(struct node* list1, struct node* list2);



ifstream in("input.txt");

struct node 
{
string data;
struct node *next;
};

int main ()
{
	node *head;
	head = Readfile();
	//Traverse(head);
	Split(head);
}

struct node* Readfile()
{
	string a = "blank";
	node *head = new node;
	while (in>>a)
		{
			node *temp = new node;
			temp->data=a;
			temp->next=head;
			head=temp;
		}
	return (head);
}

void Traverse(struct node* head)
{
	node *ptr;
	ptr = head;
	while (ptr->data != "\0")
	{
		cout<<ptr->data<<endl;
		//if(ptr->next !=NULL)
		//{
		ptr = ptr->next;
		//}
	}
}

void Split(struct node* head)
{
	node *tail = new node;
	node *list1 = new node;
	node *list2 = new node;
	int spl,i=0;
	spl = (Length(head))/2;
	list1= head;
	tail = head;
	node *cur = new node;
	while(i<spl)
	{
		cur->data=list1->data;
		cur=list1->next;
		list1 = cur;
		i++;
		
	}
	
	i=0;
	list2=head;
	node *previous=new node;
	while(i<spl)
	{
		previous=list2;
		list2=list2->next;
		i++;
	}
	previous->next = NULL;
	cout<<"List1:\n"; 	
	Traverse(list1);
	cout<<"List2:\n";
	list2 = head; 
	Traverse(list2); //program halts after this line. No clue why
	cout<<"dont";
	/*node *cmb = new node;
	cmb = Merge(list1, list2);*/
	
}

int Length (struct node* head)
{
	node *temp = new node;
  	temp = head;
  	int cnt = 1;
  	while(temp->data != "\0")
  	{
  		cnt++;
  		temp = temp->next;
	}
	return (cnt);
}


struct node* Merge(struct node* list1, struct node* list2)
{
	
	list1->next = list2;
}








