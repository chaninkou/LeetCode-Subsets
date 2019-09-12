package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllUnqiueSubsetsOfArrayFunction {
    // Contain no duplicate subsets
    // Does not need to be sorted, unless it include duplicate
    public List<List<Integer>> subsets(int[] nums) {
    	// Contain total of all subset
        List<List<Integer>> powerSet = new ArrayList<>();
        
        // Sort the array first
        Arrays.sort(nums);
        
        // Backtracking with 0 as starting point, pass in empty arraylist
        backtrack(powerSet, new ArrayList<>(), nums, 0);
        
        return powerSet;
    }
    
    private void backtrack(List<List<Integer>> powerSet, List<Integer> tempList, int[] nums, int start){
    	// We are using new ArrayList cause we don't want it to reference to it
    	powerSet.add(new ArrayList<>(tempList));
    	
    	// We try to get all the set from start and then move on to the next element
    	for(int i = start; i < nums.length; i++){
    		// Update the tempList
    		tempList.add(nums[i]);
    		
    		// So we go down the list until we reach i = nums.length which will stop the loop
    		backtrack(powerSet, tempList, nums, i + 1);
    		
    		// Remove the last element of the tempList
    		tempList.remove(tempList.size() - 1);
    	}
    	
    }
}
