package dev.rwamasirabo.api;

import java.util.Scanner;

public class api {
 public static void main(String [] args){

     Scanner input = new Scanner(System.in);

     //Scanner input= new Scanner(System.in);
     String user, pass;

     System.out.print("Enter your username: ");
     user = input.nextLine();

     System.out.print("Enter your password:");
     pass = input.nextLine();

     System.out.print("Savings Account balance: ");
     double savingaccount = input.nextDouble();
     System.out.print("Checkings Account balance: ");
     double checkingAccount = input.nextDouble();

     if (savingaccount  < 1 || checkingAccount < 1) {
         System.out.println("Balances must be greater than 0.");
         input.close();
         return;
     }
     System.out.print("Choose an operation: 1) Deposit, 2) Withdraw, 3) Transfer: ");
     int operation_choice = input.nextInt();

     if (operation_choice == 1) {
         System.out.print("To 1) Savings, 2) Checkings ?: ");
         int account_choice = input.nextInt();
         if (account_choice == 1) {
             System.out.print("Amount: ");
             double amount = input.nextDouble();
             savingaccount  += amount;
         }
         else if (account_choice == 2) {
             System.out.print("Amount: ");
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
         System.out.print("From 1) Savings, 2) Checkings ?: ");
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

