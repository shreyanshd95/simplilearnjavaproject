package com.simplilearn.longest.subsequensce;

public class LongestIncreasingSubsequence {

	
	public static void main (String[] args) {
		
		//Longest Increasing Subsequence
		System.out.println("Longest Increasing Subsequence");
		
		//Define Array List
		int[] array  = {10,22,9,33,21,50,41,60,80};
		
		//LIS = 10, 22, 33, 50, 60, 80
		
		int lenthArray = array.length;
		
		System.out.println("Array list:  ");
		
		for (int i =0; i<lenthArray;i++) {
			System.out.print(array[i]+ " , ");
		}
	
	System.out.println("\nArray list :" + lenthArray);
	
	
	System.out.println("Lenth of Longest Increasing Subsequence is :   " + lis(array,lenthArray));
	
	LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
	
	
	
	System.out.println("Lenth of Longest Increasing Subsequence is :   " + (array.length));
	System.out.println();
	}
	
	   

		
	

		private static  int lis (int[] array, int lenth) {
		
		int Lis[] = new int [lenth];
		
		int i,j, max=0;
		
		//initialize LIS value for all index
		for(i =0; i < lenth ; i++) {
			
		Lis[i] = 1;
		
	}
		//Nested Loop 
			for(i = 1; i<lenth ;i++) {
				
				for(j=0;j<i; j++) {
					
				if(array[i]>array[j] && Lis[i]<Lis[j]+1) {	
					
				Lis[i]= Lis[j]+1;
					
				}
			}
		}			
				for(i =0; i<lenth;i++) {
					if(max < Lis[i]) {
					max = Lis[i];
				}
			}
		return max ;
		
					
	  }
				
	  }
	
	  

