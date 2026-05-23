class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) {
            return n;
        }

        // Representation of ways(n-2) and ways(n-1)
        int prev2 = 1; // Ways to reach step 1
        int prev1 = 2; // Ways to reach step 2
        int current = 0;

        // Calculate iteratively up to n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1; // Shift pointers forward
            prev1 = current;
        }

        return current;
    }
}