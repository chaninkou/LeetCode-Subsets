package subsets;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		System.out.println("Input: " + Arrays.toString(nums)); 
		
		FindAllUnqiueSubsetsOfArrayFunction solution = new FindAllUnqiueSubsetsOfArrayFunction();
		
		System.out.println("Powerset without duplicate set: " +solution.subsets2(nums));
	}
}
