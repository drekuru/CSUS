package Main;

import java.util.LinkedList;
import java.util.Queue;

public class Sort
{
	public static void MergeSort(int[] a)
	{
		if(a.length <= 1)
		{
			return;
		}
		else
		{
			int [] b = breaker(a);
			
			for(int i = 0; i < a.length; i++)
				a[i] = b[i];
		}
	}
	private static int[] breaker(int [] a)
	{
		if(a.length > 1)
		{
			int middle = (int) Math.floor(a.length/2);
			int [] left = split(a, 0, middle);
			int [] right = split(a, middle, a.length);
			a = merge(breaker(left), breaker(right));
			return a;
		}
		else
		{
			return a;
		}
	}

	private static int [] merge(int [] left, int [] right)
	{
		Queue<Integer> temp = new LinkedList<>();;
		int lCounter = 0;
		int rCounter = 0;
		
		while(lCounter < left.length && rCounter < right.length)
		{
			if(left[lCounter] < right[rCounter])
			{
				temp.add(left[lCounter]);
				lCounter++;
			}
			else
			{
				temp.add(right[rCounter]);
				rCounter++;
			}
		}
		
		left = split(left, lCounter, left.length);
		right = split(right, rCounter, right.length);
		
		
		for(int i = 0; i < left.length; i++)
			temp.add(left[i]);
		for(int i = 0; i < right.length; i++)
			temp.add(right[i]);
		
		int [] res = new int [temp.size()];
		for(int i = 0; !temp.isEmpty(); i++)
		{
			res[i] = temp.remove();
		}

		
		return res;
	}
	
	private static int [] split(int [] a, int start, int end)
	{
		
		int [] res = new int [end-start];
		int k = 0;
		for(int i = start; i < end; i++)
		{
			res[k] = a[i];
			k++;
		}
			
		return res;
	}
}
