import java.util.Scanner;

public class Max {
    public static int recursiveMaxDigit(int num) {
        if (num < 10) {
            return num;
        }
        int lastDigit = num % 10;
        int remainingNum = num / 10;
        int maxRemainingNum = recursiveMaxDigit(remainingNum);
        return Math.max(lastDigit, maxRemainingNum);
    }

    public static int iterativeMaxDigit(int num) {
        int max = 0;
        while ( num > 0) {
            int digit = num % 10;
            max = Math.max(digit, max);
            num = num / 10;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Enter an integer num to get the Maxumum digit in a number: ");
        Scanner myScanner = new Scanner(System.in);
        int num = myScanner.nextInt();
        System.out.println("The maximum number in " + num + " is " + recursiveMaxDigit(num));
        System.out.println("The maximum number in " + num + " is " + iterativeMaxDigit(num));

    }
}