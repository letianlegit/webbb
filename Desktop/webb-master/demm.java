import java.util.Date;
import java.util.Scanner;

public class Example10_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account[] acc = new Account[10];
        int correctIdPos;

        for(int i = 0; i < 10; i++){
            acc[i] = new Account(i, 100);
        }
        ATM atm = new ATM(acc);

        while(true){
            System.out.println("Enter an id:");
            int id = input.nextInt();
            if(atm.checkId(id)){
                while(atm.showMenu(id));
            }
        }
    }
}

class ATM{
    private Account[] acc;
    Scanner input = new Scanner(System.in);
    final int CHECKBALANCE = 1;
    final int WITHDRAW = 2;
    final int DEPOSIT = 3;
    final int EXIT = 4;
    
    public ATM(){}

    public ATM(Account[] acc){
        this.acc = acc;
    }

    public boolean showMenu(int n){
        System.out.println("Main menu\n" +
                "1: check balance\n" +
                "2: withdraw\n" +
                "3: deposit\n" +
                "4: exit");
        return promptChoice(n);
    }

    public boolean promptChoice(int n){
        System.out.print("Enter a choice:");
        int choice = input.nextInt();
        if(choice == CHECKBALANCE){
            System.out.println("The balance is " + acc[n].getBalance());
        }
        else if(choice == WITHDRAW){
            System.out.println("Enter an amount to withdraw:");
            double withdraw = input.nextDouble();
            acc[n].withdraw(withdraw);
        }
        else if(choice == DEPOSIT){
            System.out.println("Enter an amount to deposit:");
            double deposit = input.nextDouble();
            acc[n].deposit(deposit);
        }
        else if(choice == EXIT){
            System.out.println();
        }
        return (choice <= 3);
    }

    public boolean checkId(int id){
        boolean correct = false;
        for(Account a: acc){
            if(a.getId() == id){
                correct = true;
                break;
            }
        }
        return correct;
    }
}

class Account{
    private int id;

    private double balance;

    private double annualInterestRate;
    private Date dateCreated;

    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate / 100;
    }

    public Date getDateCreated(double annualInterestRate) {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}