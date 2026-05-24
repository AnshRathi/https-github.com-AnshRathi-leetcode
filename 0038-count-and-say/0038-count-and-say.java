class Solution {
    public String countAndSay(int n) {
        // Base Case
        if (n == 1) return "1";
        
        // Start with the sequence for n = 1
        String currentString = "1";
        
        // Iteratively generate the sequence up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder nextStringBuilder = new StringBuilder();
            int len = currentString.length();
            int j = 0;
            
            // Step-by-step reading of the current string
            while (j < len) {
                char currentChar = currentString.charAt(j);
                int count = 0;
                
                // Count how many times this character repeats consecutively
                while (j < len && currentString.charAt(j) == currentChar) {
                    count++;
                    j++; // Advance the pointer safely
                }
                
                // Append the [Count][Character]
                nextStringBuilder.append(count).append(currentChar);
            }
            
            // Update currentString to the newly generated sequence
            currentString = nextStringBuilder.toString();
        }
        
        return currentString;
    }
}