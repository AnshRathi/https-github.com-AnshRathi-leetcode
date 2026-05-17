import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map will store [Number : Original Index]
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the missing partner is already in our map
            if (map.containsKey(complement)) {
                // Return the index of the complement and the current index
                return new int[] { map.get(complement), i };
            }
            
            // If not found, remember this number and its original index
            map.put(nums[i], i);
        }
        
        return new int[] {}; // Fallback, though a solution is guaranteed
    }
}