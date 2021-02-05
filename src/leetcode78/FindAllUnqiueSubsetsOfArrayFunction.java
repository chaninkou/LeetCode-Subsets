package leetcode78;

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
    
    // Using index to keep track of where to begin adding
    private void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start){
    	// Add the new set of subset to the total subsets, starting from []
    	// We create new ArrayList cause we don't want it to reference to it, we want a complete copy of it
    	subsets.add(new ArrayList<>(tempList));
    	
    	// We don't need do anything to prevent duplicates since start will keep track of the last element
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
    
    // A faster way to do it without backtrack, hard to master
    public List<List<Integer>> subsets2(int[] nums){
    	List<List<Integer>> result = new ArrayList<>();
    	
    	// Or use Collections.<Integer>emptyList()) for empty list
    	result.add(new ArrayList<>());
    	
    	for(int i = 0; i < nums.length; i++){
    		List<List<Integer>> whatToAdd = new ArrayList<>();
    		
    		// For each elements in our result array list
    		// ex: [1]
    		// [2], [1,2]
    		// [3], [2,3], [1,2,3]
    		for(List<Integer> subset : result){
    			
    			// Put the item in the list first
    			List<Integer> copyOfsubset = new ArrayList<>(subset);
    			
    			// Add the input element
    			copyOfsubset.add(nums[i]);
    			
    			// Finally add it to a list that will be store in result list after this loop finishes
    			whatToAdd.add(copyOfsubset);
    		}
    		
    		result.addAll(whatToAdd);
    	}
    	
    	return result;
    	
    }
}
