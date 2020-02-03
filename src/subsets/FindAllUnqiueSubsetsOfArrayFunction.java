package subsets;

import java.util.ArrayList;
import java.util.List;

public class FindAllUnqiueSubsetsOfArrayFunction {
    // Contain no duplicate subsets
	// Does not need to be sorted, unless it contains duplicate input
    public List<List<Integer>> subsets(int[] nums) {
    	// Contain total of all subset
        List<List<Integer>> subsets = new ArrayList<>();
        
        // Backtracking with 0 as starting point since we start from index 0
        backtrack(subsets, new ArrayList<>(), nums, 0);
        
        return subsets;
    }
    
    // This is similar to permutation problem, but we want to add every recursive, and have the starting index without duplicates subset
    private void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start){
    	// Add the new set of subset to the total subsets, starting from []
    	// We create new ArrayList cause we don't want it to reference to it, we want a complete copy of it
    	subsets.add(new ArrayList<>(tempList));
    	
    	// We try to get all the set from start and then move on to the next element
    	for(int i = start; i < nums.length; i++){
    		// Add current element to tempList
    		tempList.add(nums[i]);
    		
    		// Reason why we using i + 1, so that we could backtrack the next element
    		// Important to use i + 1, we don't do i++ cause we do want the next element too
    		backtrack(subsets, tempList, nums, i + 1);
    		
    		// Remove the last element of the tempList, since we got one of the subset
    		tempList.remove(tempList.size() - 1);
    	}
    	
    }
}
