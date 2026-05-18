class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap current element with the low pointer boundary
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // 1s stay right where they are in the middle
                mid++;
            } 
            else { // nums[mid] == 2
                // Swap current element with the high pointer boundary
                swap(nums, mid, high);
                high--;
                // Notice: mid is NOT incremented here because we need 
                // to check the element that just came from the back!
            }
        }
    }

    // Helper method to swap elements in place
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}