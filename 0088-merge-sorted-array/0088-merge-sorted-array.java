class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize three pointers
        int p1 = m - 1;     // Last valid element in nums1
        int p2 = n - 1;     // Last element in nums2
        int p = m + n - 1;  // Last slot of the merged nums1 array
        
        // Move backwards, comparing elements from the end of both arrays
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        
        // If there are remaining elements in nums2, copy them over.
        // If nums1 has remaining elements, they are already in their correct places!
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}