import java.util.Scanner;

public class Histogram {
    private int[] histogramArray;
    private int lowerbound;
    private int upperbound;

    public Histogram(int lowerbound, int upperbound) {
        if (upperbound < lowerbound) {
            lowerbound= upperbound;
            upperbound = lowerbound;
            
        }
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
        this.histogramArray = new int[upperbound - lowerbound + 1];
    }

    public boolean add(int i) {
        if (i >= lowerbound && i <= upperbound) {
            histogramArray[i - lowerbound]++;
            return true;
        } else {
            return false; 
        }
    }

    public String toString() {
        String histogramString = "";
        for (int i = 0; i < histogramArray.length; i ++) {
            histogramString += (i + lowerbound) + ": " + "*".repeat(histogramArray[i]) + "\n";
        }
        return histogramString;
    }

    public static void main(String[] args) {
        Histogram histo = new Histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
    }
}
class HistogramApp {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("---Histogram Console---");
        System.out.println("Options");
        System.out.println("add - used to add numbers to the histogram");
        System.out.println("print - prints the histogram to the screen");
        System.out.println("quit - leaves the program");

        int lowerbound = myScanner.nextInt();
        System.out.println("Enter a lower bound: " + lowerbound);
        int upperbound = myScanner.nextInt();
        System.out.println("Enter an upper bound: " + upperbound);
        
        Histogram hist = new Histogram(lowerbound, upperbound);
        while (true) {
            String choice = myScanner.nextLine();
            if (choice.equals("add")) {
                System.out.println("Enter a number: ");
                String input = myScanner.nextLine();
                // if (Integer.parseInt(input) >= lowerbound && Integer.parseInt(input) <=  upperbound); {
                //     hist.add(Integer.parseInt(input));
                // } else {
                //     System.out.println(input + " is not in the range");
                // }
                String []numbers = input.split(" ");
                for (int i = 0; i < numbers.length; i ++) {
                    if (!hist.add(Integer.parseInt(numbers[i]))){
                        System.out.println(numbers[i] + " is not in the range");
                    }
                }
            } else if (choice.equals("print")) {
                System.out.println(hist.toString());
            } else if (choice.equals("quit")) {
                System.out.println("Bye");
                break;
            }
        }
    }
}