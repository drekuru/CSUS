#include <iostream>
#include <fstream>
#include <string>
using namespace std;

struct Treenode *CreateNode(string name);
void Search(struct Treenode *&root, string name);
ifstream in("input.txt");


struct node
{
	string name;
	struct node *next;
};

struct Treenode{
	string data;
	struct Treenode *left;
	struct Treenode *right;
	struct node *dup;
	int counter = 1;
};
int main ()
{
	string a;
	Treenode *root = new Treenode;
	root = NULL;
	while (in>>a)
	{
		if (root == NULL)
		{
			root = CreateNode(a);
		}
		else
		{
			Treenode *cur = new Treenode;
			cur = root;
			while (cur)
			{
				if (a.compare(cur->data) == 0)
				{
					node *nn = new node;
					nn->name = a;
					nn->next = NULL;
						if(cur->dup == NULL)
						cur->dup = nn;
						else
						{
							node *listcur = new node;
							listcur = cur->dup;
							while(listcur->next)
							{
								listcur = listcur->next;
							}
							listcur->next = nn;
						}
						cur->counter++;
					break;
				}
				else if (a.compare(cur->data) < 0)
				{
					if(cur->right)
					cur = cur->right;
					else
					{
					cur->right = CreateNode(a);;
					break;
					}
					
				}
				
				else if (a.compare(cur->data) > 0)
				{
					if(cur->left)
					cur = cur->left;
					else
					{
					cur->left = CreateNode(a);
					break;
					}
					
				}
				
			}
		}
	}

	Search(root, "Troy");
	cout<<endl<<endl;
	Search(root, "Dan");
	
}

struct Treenode *CreateNode(string name)
{
	Treenode *temp = new Treenode;
	temp->left=temp->right = NULL;
	temp->dup=NULL;
	temp->data=name;
	return temp;
}

void Search(struct Treenode *&root, string name)
{
		Treenode *index = root;
		if(index->data==name)
		{
			cout<<"Found name "<<index->data<<endl;
			if (index->counter > 1)
			cout<<"There are "<<index->counter<<" "<<index->data<<"'s"<<endl;
		}
		else if (name.compare(index->data) > 0)
		{
			cout<<index->data<<endl;
			if(index->left == NULL)
			cout<<"No name found"<<endl;
			else
			Search(index->left, name);
		}
		else if (name.compare(index->data) < 0)
		{
			cout<<index->data<<endl;
			if(index->right == NULL)
			cout<<"No name found"<<endl;
			else
			Search(index->right, name);
		}
}














