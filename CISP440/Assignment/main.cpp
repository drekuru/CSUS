#include <iostream>
#include <iomanip>
#include "parser.h"
using namespace std;

#define MAX_ROWS 8
#define MAX_COLS 10

///Initialize the table for all possible truth values of p, q, and r
///Give each symbol its own column, as we have done in class
///You can assign truth values manually or use nested loops.  I used a triple nested loop.
///returns the number of columns currently in the table (3)
int initTable(string symbols[], bool table[MAX_ROWS][MAX_COLS])
{
    symbols[0] = "p";
    symbols[1] = "q";
    symbols[2] = "r";
     
	int counter = 0;

	for(int i = 0; i <= 1; i++)
	{for(int j = 0; j <= 1; j++)
	 {for(int h = 0; h <= 1; h++)
	  {
		int col = 0;
		table[counter][col] = i;
		table[counter][col+1] = j;
		table[counter][col+2] = h;
		counter++;
		}
	 }
	}

    ///assign table

    return 3;
}

///output the contents of the table with number of columns equal to numProps
///the table should contain p, q, r, each hypothesis, and the conclusion in the last column
///I would recommend using cout << setw(symbols[j].size() + 2) to set the width of each column
void printTable(string symbols[], bool table[MAX_ROWS][MAX_COLS], int numProps)
{
	int i = 0;
	for (int f = 0; f < 3; f++)
		cout << symbols[f] << " ";
		cout << "  ";
		for (int f = 3; f < numProps; f++)
			cout << symbols[f] << " ";
		cout << endl;

	for (i = 0; i < 8; i++) {
		
		for (int j = 0; j < 3; j++)
		cout << table[i][j] << " ";
		cout << "	           ";
		for (int z = 3; z < numProps; z++)
		cout << table[i][z] << " ";
		cout << endl;
	}
}

///Append a new column to the table.  Returns the new total number of columns.
///Assign the statement to the next column in symbols to act as a column header
///loop through each row and plug the current row's values for p, q, and r into evaluate
///Assign the return value from evaluate to the corresponding new cell in the table
int appendColumn(string statement, string symbols[], bool table[MAX_ROWS][MAX_COLS], int numProps)
{
	symbols[numProps] = statement;
	for (int i = 0; i < 8; i++)
	{
		int j = 0;
		table[i][numProps] = evaluate(table[i][j], table[i][j + 1], table[i][j + 2], statement);
	}
    ///fill in the column header and truth values
    
    numProps++;
    return numProps;
}

///Determine if the argument represented by the truth table is valid or invalid
///As described in class, an argument is valid if when all the hypotheses are true, the conclusion is also true
///If there is a case where each hypothesis is true but the conclusion is false, the argument is invalid
///Use nested loops to examine each row.  If you find a row where all hypotheses are T and conclusion is F, return false
///If your code makes it through the loop without returning false, then return true
bool isValid(bool table[MAX_ROWS][MAX_COLS], int numProps)
{
	bool var = true;
	for (int i = 0; i < 8; i++)
	{
		if (table[i][numProps] == false)
		{
			int j = 3;
			while (j < numProps)
			{
				if (table[i][j] == true)
					j++;
				else
				{
					var = false;
					return var;
				}
			}
		}
		
		}
	return var;
}

///This one is done, no need to change it.
void printro()
{
    cout << "Welcome to the truth table generator" << endl;
    cout << "Valid symbols are p, q, and r" << endl;
    cout << "Valid operators are \\/, /\\, ~, =>, and <=>" << endl;
    cout << "Whitespace is ignored" << endl;
    cout << "Example:  (p \\/ q) => r" << endl;
}

///main is done, no changes needed.
int main()
{
    bool table[MAX_ROWS][MAX_COLS];
    string symbols[MAX_COLS];

    int numProps = initTable(symbols, table);

    printro();

    string statement = "";
    cout << "Enter a hypothesis or type \"therefore\" when done: ";
    getline(cin, statement);

    while(statement != "therefore")
    {
        numProps = appendColumn(statement, symbols, table, numProps);
        printTable(symbols, table, numProps);
        cout << "Enter a hypothesis or type \"therefore\" when done: ";
        getline(cin, statement);
    }

    cout << "Enter the conclusion: ";
    getline(cin, statement);
    numProps = appendColumn(statement, symbols, table, numProps);
    printTable(symbols, table, numProps);

    bool valid = isValid(table, numProps);
    if(valid) cout << "The argument IS valid" << endl;
    else cout << "The argument is NOT valid" << endl;

    return 0;
}