class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, there are 0 unique elements
        if (nums.length == 0) return 0;

        int off = 1; 

        for (int cm = 1; cm < nums.length; cm++) {
            
            if (nums[cm] != nums[cm - 1]) {
                nums[off] = nums[cm]; // Write the unique number to the 'off' position
                off++;                // Move the write pointer forward
            }
        }
        
        
        return off; 
    }
}