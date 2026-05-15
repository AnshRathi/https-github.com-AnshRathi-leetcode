class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Array to store the last index of each character (ASCII 128)
        int[] lastSeen = new int[128];
        // Initialize with -1 to indicate character hasn't been seen
        java.util.Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If we've seen this char before and it's inside our current window
            if (lastSeen[currentChar] >= left) {
                // Jump the left pointer to right after the previous occurrence
                left = lastSeen[currentChar] + 1;
            }
            
            // Update the last seen position of the character
            lastSeen[currentChar] = right;
            
            // Calculate current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}