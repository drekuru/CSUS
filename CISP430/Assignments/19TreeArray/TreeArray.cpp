#include <iostream>
#include <fstream>
#include <string>
#include <stack> 
using namespace std;

struct Treenode *CreateNode(int input);
void Search(struct Treenode *&root, int input);
void Readfile(struct Treenode *&root);
void inorder(struct Treenode *&root);
struct Treenode *insert(struct Treenode *&node, int input) ;
void treeToUnsorted(Treenode *&leaf, int i, int array []);
void preOrder(Treenode *root);
void balance(struct Treenode *&root);

ifstream in("input.txt");
struct node
{
	int data;
	struct node *next;
};

struct Treenode{
	int data;
	struct Treenode *left;
	struct Treenode *right;
	struct node *dup;
	int counter = 1;
	int height;
};


int main ()
{
	int a;
	Treenode *root = new Treenode;
	root = NULL;
	Readfile(root);
	//inorder(root);
	
	int b[7];
	treeToUnsorted(root,0,b);
	
	 preOrder(root);
	
	
	
	
}

struct Treenode *CreateNode(int input)
{
	Treenode *temp = new Treenode;
	temp->left=temp->right = NULL;
	temp->dup=NULL;
	temp->data=input;
	return temp;
}

void Search(struct Treenode *&root,int input)
{	
		Treenode *index = root;
		if(index->data == input)
		{
			cout<<"Found number "<<index->data<<endl;
			if (index->counter > 1)
			cout<<"There are "<<index->counter<<" "<<index->data<<"'s"<<endl;
		}
		else if (input < index->data)
		{
			cout<<index->data<<endl;
			if(index->left == NULL)
			cout<<"No number found"<<endl;
			else
			Search(index->left, input);
		}
		else if (input > index->data)
		{
			cout<<index->data<<endl;
			if(index->right == NULL)
			cout<<"No number found"<<endl;
			else
			Search(index->right, input);
		}
}

void Readfile(struct Treenode *&root)
{
	int a;
	while(in>>a)
	{
		root = insert(root, a);
	}
}

void inorder(struct Treenode *&root) 
{ 
	Treenode *cur = new Treenode;
	cur = root;
    if (cur != NULL) 
    { 
        inorder(cur->left); 
     	cout<<cur->data<<endl;
        inorder(cur->right); 
    } 
} 

struct Treenode *insert(struct Treenode *&root, int input) 
{ 
	Treenode *cur = new Treenode;
	cur = root;
   	if (cur == NULL) return CreateNode(input);
	
	if(input < cur->data)
		cur->left = insert(cur->left, input);
  	else if (input > cur->data)
	  	cur->right = insert(cur->right, input); 
	
    return cur; 
} 

void treeToUnsorted(Treenode *&leaf, int i, int array[]) {         //preorder
    if (leaf != NULL) {
        array[i] = leaf->data;
        treeToUnsorted(leaf->left,2*i+1 , array);
        treeToUnsorted(leaf->right,2*i+2, array);
    }
    for(int j = 0; j<6; j++)
    cout<<array[j]<<" ";
    cout<<"\n";
}

void preOrder(Treenode *root) 
{ 
    Treenode *cur = new Treenode;
	cur = root;
    if (cur != NULL) 
    { 
    	cout<<cur->data<<endl;
        inorder(cur->left); 
        inorder(cur->right); 
    } 
} 

void balance(struct Treenode *&root)
{
	
}
