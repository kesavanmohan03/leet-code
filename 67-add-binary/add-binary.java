class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are digits to process or a remaining carry
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // Append the binary digit (0 or 1)
            sb.append(sum % 2);
            // Calculate the new carry (1 if sum >= 2, else 0)
            carry = sum / 2;
        }

        // The digits were added in reverse order, so flip the string back
        return sb.reverse().toString();
    }
}
