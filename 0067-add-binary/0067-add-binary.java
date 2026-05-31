class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        // Pointers for both strings starting at the last character
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are digits to process OR a carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            // Add digit from string 'a' if pointer is in bounds
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }

            // Add digit from string 'b' if pointer is in bounds
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            // Append the remainder bit (0 or 1)
            result.append(sum % 2);

            // Calculate the new carry (0 or 1)
            carry = sum / 2;
        }

        // Since we added bits from right to left, reverse the final string
        return result.reverse().toString();
    }
}