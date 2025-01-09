import java.util.Scanner;

public class BankAccount {
    private String name;
    private String password;
    private double balance;

    public void withdraw(String enteredPassword, double amount) {
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;
        }
    }

    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        } 
    }
    
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("myAccount", "CSCI1933 Rules!", 100.50);
        // myAccount.password = "CSCI1933 rules!";
        // myAccount.deposit("CSCI1933 rules!", 100.50);
        // System.out.println("My account's balance is: " + myAccount.getBalance());
        // System.out.println("Enter your password: ");
        // Scanner myScanner = new Scanner(System.in);
        // String input = myScanner.nextLine();
        // System.out.println("Your balance is: " + myAccount.getBalance(input));

        BankAccount Dovolis = new BankAccount("Dovolis", "CSCI1933 Rules!", 1000);
        BankAccount Taylor = new BankAccount("Taylor", "CSCI1133 Rules!", 100);

        Dovolis.transfer(Taylor, "CSCI1933 Rules!", 100);
        System.out.println("Dovolis's balance: " + Dovolis.getBalance("CSCI1933 Rules!"));
        System.out.println("Taylor's balance: " + Taylor.getBalance("CSCI1133 Rules!"));
    }

    public void transfer(BankAccount other, String enteredPassword, double amount) {
        System.out.println("Enter the other account's password: ");
        Scanner myScanner = new Scanner(System.in);
        String otherPass = myScanner.nextLine();
        if (otherPass.equals(other.getPassword())) {
            withdraw(enteredPassword, amount);
            other.deposit(otherPass, amount);
        }

    }

    public BankAccount(String initName, String initPass, double initBalance) {
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public boolean setPassword(String oldPassword, String newPassword){
        if (password.equals(oldPassword)){
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)){
            return balance;
        } else {
            return -1;
        }
    }

    public static int sumDigits(int n) {
        //eg. n = 2041 => 7 
        int sum = 0;
        while (n>0) {
            sum = sum + n%10;
            n = n/10;
        }
        return sum;   
    }

    public static void main(string[] args) {
        int x = 0;
        Complex4 comp = new Complex4(0.0, 0.0);
        int[] a = {0,0,0};
        changer(x, comp, a);
    }
    public static void changer(int i, Complex4 c, int[] a) {
        i = 777;
        c.setRealPart(777);
        a[0] = 777;
    }
}

    
