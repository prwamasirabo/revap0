package dev.rwamasirabo.api;

import dev.rwamasirabo.data.BankDAOPostgresImpl;
import dev.rwamasirabo.entities.BankUser;
import dev.rwamasirabo.services.BankService;
import dev.rwamasirabo.services.BankServiceImpl;

import java.util.Scanner;

public class api {


    public static void main(String [] args){
         BankService bankService = new BankServiceImpl (new BankDAOPostgresImpl());
//        ps.setString(1, bankUser.getFirstName());
//        ps.setString(2, bankUser.getLastName());
//        ps.setString(4, bankUser.getUserName());
//        ps.setString(3, bankUser.getPassword());
//        ps.setString(4, bankUser.getEmail());

     BankUser newBankUser = new BankUser ();

     Scanner input = new Scanner(System.in);
     System.out.print("------------------------------\n");
     System.out.print("Welcome to Our Banking System:\n");
     System.out.print("------------------------------\n \n ");
     //Scanner input= new Scanner(System.in);
     String firstname,lastname,username, pass,  email ;

     System.out.print("Enter your first name: ");
        firstname = input.nextLine();
      newBankUser.setFirstName(firstname);

      System.out.print("Enter your last name: ");
        lastname = input.nextLine();
      newBankUser.setLastName(lastname);

     System.out.print("Enter your username: ");
        username = input.nextLine();
     newBankUser.setUserName(username);

     System.out.print("Enter your password:");
     pass = input.nextLine();
     newBankUser.setPassword(pass);

      System.out.print("Enter your email:");
        email = input.nextLine();
     newBankUser.setEmail(email );

     System.out.println("Welcome to our banking System your account has been created :\n ");


    bankService.createBankUser(newBankUser);

     System.out.print("Choose an operation you would like today:\n  1) Deposit,\n 2) Withdraw,\n 3) Transfer \n  ");
     int operation_choice = input.nextInt();

     System.out.print("Savings Account balance: ");
     double savingaccount = input.nextDouble();
     System.out.print("Checkings Account balance: ");
     double checkingAccount = input.nextDouble();

     if (savingaccount  < 1 || checkingAccount < 1) {
         System.out.println("Balances must be greater than 0.");
         input.close();
         return;
     }
     //System.out.print("Choose an operation: 1) Deposit,\n 2) Withdraw,\n 3) Transfer: ");
     //int operation_choice = input.nextInt();

     if (operation_choice == 1) {
         System.out.print("To 1) Savings \n  2) Checkings ?: ");
         int account_choice = input.nextInt();
         if (account_choice == 1) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             savingaccount  += amount;
         }
         else if (account_choice == 2) {
             System.out.print("Amount:");
             double amount = input.nextDouble();
             checkingAccount += amount;
         }
         else {
             System.out.print("Unknown account number.");
             input.close();
             return;
         }
     }
     else if (operation_choice == 2) {
         System.out.print("From 1) Savings \n  2) Checkings ?: ");
         int account_choice = input.nextInt();
         if (account_choice == 1) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             if (savingaccount  - amount < 0) {
                 System.out.println("Withdraw amount exceeds savings balance.");
                 input.close();
                 return;
             }
             savingaccount  -= amount;
         }
         else if (account_choice == 2) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             if (savingaccount - amount < 0) {
                 System.out.println("Withdraw amount exceeds savings balance.");
                 input.close();
                 return;
             }
             checkingAccount -= amount;
         }
         else {
             System.out.print("Unknown account number.");
             input.close();
             return;
         }
     }
     else if (operation_choice == 3) {
         System.out.print("From 1) Savings, 2) Checkings: ");
         int from_choice = input.nextInt();
         System.out.print("To 1) Savings, 2) Checkings: ");
         int to_choice = input.nextInt();

         if (from_choice == to_choice) {
             System.out.println("Same account to transfer from and to");
             input.close();
             return;
         }
         else if (from_choice == 1) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             if (savingaccount  - amount < 0) {
                 System.out.print("Transfer amount exceeds balance");
                 input.close();
                 return;
             }
             savingaccount  -= amount;
             checkingAccount += amount;
         }
         else if (from_choice == 2) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             if (checkingAccount - amount < 0) {
                 System.out.print("Transfer amount exceeds balance");
                 input.close();
                 return;
             }
             checkingAccount -= amount;
             savingaccount  += amount;
         }
         else {
             System.out.println("Invalid accounts chosen");
             input.close();
             return;
         }
     }
     else {
         System.out.println("Invalid operation choice");
         input.close();
         return;
     }
     input.close();
     System.out.println("Savings balance: " + savingaccount);
     System.out.println("Checkings balance: " + checkingAccount);
 }

}

