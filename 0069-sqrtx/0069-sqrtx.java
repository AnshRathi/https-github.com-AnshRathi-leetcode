class Solution {
    public int mySqrt(int x) {
        // Edge cases for 0 and 1
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use division instead of multiplication to prevent integer overflow
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                result = mid; // Store mid as a potential rounded-down answer
                left = mid + 1; // Try to find a larger value
            } else {
                right = mid - 1; // mid is too big, look lower
            }
        }

        return result;
    }
}