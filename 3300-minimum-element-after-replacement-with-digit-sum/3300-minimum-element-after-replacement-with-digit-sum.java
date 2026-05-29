class Solution {
    public int minElement(int[] nums) {
        int minDigitSum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int currentDigitSum = 0;
            int temp = num;
            
            // Extract each digit and sum them up
            while (temp > 0) {
                currentDigitSum += temp % 10;
                temp /= 10;
            }
            
            // Update the minimum tracking variable
            if (currentDigitSum < minDigitSum) {
                minDigitSum = currentDigitSum;
            }
        }
        
        return minDigitSum;
    }
}