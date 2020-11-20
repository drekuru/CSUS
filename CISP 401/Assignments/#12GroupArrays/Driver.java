import java.util.*;
import javax.swing.*;

class Driver{
	static int counter;
	static int input = 0;
	static Scanner reader = new Scanner(System.in);

	public static void main(String [] args)
	{
		Integer [] intG;
		int[] myArr = new int [2];
		myArr = userInput(myArr);
		int [] temp = new int [myArr.length];
		System.arraycopy(myArr, 0, temp, 0, myArr.length);
		displayArr(myArr);
		intG = Arrays.stream(myArr).boxed().toArray( Integer[]::new );
		reader.close();
		System.out.println("\nGoing backwards...");
		displayArrback(myArr);
		Arrays.sort(myArr);
		System.out.println("\nLeast to Greatest: ");
		displayArr(myArr);
		Arrays.sort(intG, Collections.reverseOrder());
		displayArr(intG);
	}

	static int [] userInput(int arr [])
	{
		do{
			System.out.println("Pleae enter an integer, -1 ends sequence");
			input = reader.nextInt();

				if(checkDupes(arr) == true && input != -1)
				{
						if (counter == arr.length)
						{arr = sizeInc(arr);}
					arr[counter] = input;
					counter++;
				}
		}while(input != - 1);
		return arr;
	}

	static boolean checkDupes(int [] arr)
	{
		boolean var = true;
		outer:
		for(int i = 0; i<arr.length; i++)
		{
			if(input != arr[i])
			{
				var =  true;
			}
			else if (input == arr[i])
			{
				var = false;
				break outer;
			}
		}
		return var;
	}

	static int [] sizeInc(int Array [])
	{
		int[] temp = new int [counter*2];
		System.arraycopy(Array, 0, temp, 0, Array.length);
		return Array = temp;
	}
	static void displayArr(int [] Array)
	{
		for(int i = 0; i < Array.length; i++)
		System.out.print(Array[i] + ", ");
	}

	static void displayArrback(int [] Array)
	{
		for(int i = counter - 1; i >= 0 ; i--)
		System.out.print(Array[i] + ", ");
	}

	static void displayArr(Integer [] Array)
	{
		System.out.println("\nDisplaying Array, descending :");
		for(int i = 0; i < Array.length; i++)
		System.out.print(Array[i] + ", ");
	}
}
