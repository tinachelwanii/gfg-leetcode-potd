//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); // Read number of test cases

        while (t-- > 0) {
            int n =
                Integer.parseInt(read.readLine()); // Read the number to check primality
            Solution ob = new Solution();
            if (ob.isPrime(n)) {
                System.out.println("true"); // If the number is prime, print "true"
            } else {
                System.out.println(
                    "false"); // If the number is not prime, print "false"
            }
            System.out.println("~"); // If the number is not prime, print "false"
        }
    }
}

// } Driver Code Ends


class Solution {
    static boolean isPrime(int n) {
        // Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }
        // 2 is the only even prime number
        if (n == 2) {
            return true;
        }
        // Eliminate all even numbers greater than 2
        if (n % 2 == 0) {
            return false;
        }
        // Check divisors from 3 to √n (only odd numbers)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        // If no divisors were found, the number is prime
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPrime(1));  // Output: false
        System.out.println(isPrime(2));  // Output: true
        System.out.println(isPrime(3));  // Output: true
        System.out.println(isPrime(4));  // Output: false
        System.out.println(isPrime(29)); // Output: true
    }
}

