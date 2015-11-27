package tests;

import java.util.Random;

public class RandomArrayGenerator {
	
	public static int[] generate(){
		
		int[] ret = new int[10000000];
		
		Random r = new Random();
		
		for (int i = 0; i < ret.length; i++) {
			ret[i] = r.nextInt();
		}
		
		return ret;
		
	}
	
	public static void sort(int[] array, int a, int b){ 
			
		int tmp;
		int val = array[(a + b) / 2];
		
		int i = a;
		int j = b;
		
		do {
			while (array[i] < val)
				i++;
			
			while (val < array[j])
				j--;
			
			if (i<=j) {
				tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
				j--;
			}
		}
		while (i <= j);
		
		if ( a < j )
			sort(array, a, j);
		if ( i < b )
			sort(array, i, b);
		
	}
	
}
