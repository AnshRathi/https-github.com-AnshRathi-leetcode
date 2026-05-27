class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        // Start with the base sequence for n = 1
        String currentString = "1";
        
        // Iteratively generate sequences from 2 up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder nextStringBuilder = new StringBuilder();
            int len = currentString.length();
            int j = 0;
            
            while (j < len) {
                char currentChar = currentString.charAt(j);
                int count = 0;
                
                // Count consecutive occurrences of currentChar
                while (j < len && currentString.charAt(j) == currentChar) {
                    count++;
                    j++; 
                }
                
                // Construct the "Say" segment: [Count][Character]
                nextStringBuilder.append(count).append(currentChar);
            }
            
            // Move to the next string sequence
            currentString = nextStringBuilder.toString();
        }
        
        return currentString;
    }
}