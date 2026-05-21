class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num; // XOR the current number with our running total
        }
        
        return result;
    }
}