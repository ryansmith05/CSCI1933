import java.util.Scanner;

public class Fib {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n; 
        }
        int prev1 = 0, prev2 = 1; 
        for (int i = 2; i <= n; i++) {
            int sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println("Enter an integer n to get the n'th Fibonacci number: ");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println("The " + n + "'th Fibonacci numer using fibonacciRecursive is " + fibonacciRecursive(n));
        System.out.println("The " + n + "'th Fibonacci number using fibonacciIterative is " + fibonacciIterative(n));
    }
}
