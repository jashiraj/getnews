package in.freshnews.getnews;
import java.util.ArrayList;
import java.util.Scanner;
class Account{
    String accountHolderName;
    double accountNumber;
    double accountBalance;

    public Account(String accountHolderName, double accountNumber, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public double addMoney(int amount){
        return this.accountBalance+=amount;
    }
    public double withdrawMoney(int amount){
        return this.accountBalance-=amount;
    }
    public String displayAccountInfo(){
        return "name: " +getAccountHolderName()+" Account: " +getAccountNumber()+" balance: " +getAccountBalance();
    }

   /* @Override
    public String toString() {
        return "Account{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }*/
}
class Bank{

    ArrayList<Account> collectionOfAccounts = new ArrayList<>();
    public void addAccount(Account account) {
        collectionOfAccounts.add(account);
    }
    public void removeAccount(Account account) {
        collectionOfAccounts.remove(account);
    }
    public ArrayList < Account > getAccounts() {
        return collectionOfAccounts;
    }

}
public class OopsConcept {
    public static void main(String[] args) {
        Account account1 = new Account("vishal" , 123, 100000);
        Account account2 = new Account("jassi" , 124, 200000);
        Account account3 = new Account("gunnu" , 122, 500000);
        Bank bank = new Bank();
       System.out.println("initial record " +account1.displayAccountInfo());
        System.out.println("initial record " +account2.displayAccountInfo());
        System.out.println("initial record " +account3.displayAccountInfo());
        System.out.println("entering Rs 1000 in account 123");
        System.out.println("after adding amount " +account1.addMoney(1000));
        String a = account1.displayAccountInfo();
        System.out.println(a);
        System.out.println("withdrawing Rs 2000 from account 124");
        System.out.println("after adding amount " +account2.withdrawMoney(2000));
        String b = account2.displayAccountInfo();
        System.out.println(b);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.removeAccount(account2);
       ArrayList<Account> collectionOfAccounts = bank.getAccounts();
       // System.out.println(collectionOfAccounts);----it will display hashcode [in.freshnews.getnews.Account@675d3402, in.freshnews.getnews.Account@51565ec2]
         for(Account element:collectionOfAccounts)
        {
            System.out.println(element.displayAccountInfo());
        }

       /* ArrayList<Account> collectionOfAccounts = new ArrayList<>();
        collectionOfAccounts.add(account1);
        collectionOfAccounts.add(account2);
        collectionOfAccounts.remove(account1);
        for(Account element:collectionOfAccounts)
        {
            System.out.println(element);
        }*/
    }
}