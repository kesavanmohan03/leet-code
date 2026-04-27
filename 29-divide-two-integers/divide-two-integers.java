class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (which exceeds 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during calculations
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int quotient = 0;

        while (lDividend >= lDivisor) {
            long tempDivisor = lDivisor;
            int multiple = 1;
            
            // Double the divisor as much as possible without exceeding dividend
            while (lDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            lDividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
