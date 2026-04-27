class Solution {
    public double myPow(double x, int n) {
        // Handle n = 0 case
        if (n == 0) return 1.0;
        
        // Use long to prevent overflow when n is Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        // Iterative binary exponentiation
        while (N > 0) {
            // If the current power is odd, multiply the result by the current base
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base and halve the power
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return result;
    }
}
