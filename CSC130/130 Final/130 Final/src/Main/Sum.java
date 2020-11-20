package Main;
import java.util.HashMap;
import java.util.Arrays;


public class Sum
{
//	public static int[] threeSum(int[] b, int sum)
//	{
//		int [] a = {6,2,2,2,8,9,4,2,5,6,10,0,3};
//		//HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		Arrays.sort(a);
//		
//		for(int i = 0; i < a.length - 2; i++)
//		{
//			int end = a.length - 1; //end of array
//			int begin = i + 1; //element in front of i
//			
//			while (begin < end)
//			{
//				if(a[i] + a[begin] + a[end] == sum)
//				{
//					System.out.println("Found 3 Sum");
//					int [] ret = new int [3];
//					
//					ret[0] = a[i];
//					ret[1] = a[begin];
//					ret[2] = a[end];
//					return ret;
//				}
//				else if(a[i] + a[begin] + a[end] < sum)
//				{
//					//System.out.println(a[i] + " " + a[begin] + " " +  a[end]);
//					begin++;
//				}
//				else
//				{
//					end--;
//				}
//			}
//		}
//		
//		// TODO: Remove when complete
//		return null;	// Placeholder to prevent Java error; remove when complete
//	}

	
	public static int [] threeSum(int [] a, int sum)
	{
		Arrays.sort(a);
		
		for(int i = 0; i < a.length - 2; i++)
		{
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //init hashmap
			int complement = sum - a[i];// a + b + c = sum so a + b = sum - c
			
			for(int j = i + 1; j < a.length; j++)
			{
				if(!map.containsKey((complement - a[j])))
				{
					map.put(a[j], j);
				}
				else
				{
					int [] ret = new int [3];
					ret[0] = a[i];
					ret[1] = a[j];
					ret[2] = complement - a[j];
					return ret;
				}
			}
		}
		
		return null;
	}


}