class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, there are 0 unique elements
        if (nums.length == 0) return 0;

        // 'off' starts at 1 because nums[0] is already uniquely placed
        int off = 1; 

        // Use a for loop so 'cm' automatically increments every turn
        for (int cm = 1; cm < nums.length; cm++) {
            
            // If the current number is NOT a duplicate of the previous one
            if (nums[cm] != nums[cm - 1]) {
                nums[off] = nums[cm]; // Write the unique number to the 'off' position
                off++;                // Move the write pointer forward
            }
        }
        
        // 'off' perfectly tracks the total count of unique elements placed
        return off; 
    }
}