/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
/* Alejandro Rodriguez
 * Period 2
 * ATM Lab
 */
import java.util.Scanner;
public class ATM {
    static Scanner in = new Scanner(System.in);
    private static final String USERNAME = "user";
    private static final int PIN = 1234;
    private static double balance = 0.0;
    public static void main(String[] args) {
        System.out.println("Login: ");
        System.out.print("Username > ");
        String uName = in.nextLine();
        System.out.print("PIN > ");
        int pNumber = in.nextInt();
        System.out.println();
        
        if (uName.equals(USERNAME) && pNumber == PIN){
            System.out.println("WELCOME, "+USERNAME+"!");
            accountManagement();
        }
        else{
            System.out.println("Your account has been locked");
            System.exit(0);
        }
        }
    public static void accountManagement(){
            System.out.println();
            System.out.println("+++++++++++Account: "+USERNAME+"++++++++++++");
            System.out.println();
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Checks");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Logout");
            System.out.print("\nWhat would you like to do? > ");
            int choice = in.nextInt();
            
            if (choice == 1)
                    checkBalance();
            else if (choice==2)
                    depositChecks();
            else if (choice == 3)
                withdrawMoney();
            else if (choice == 4){
                System.out.println("\nGOODBYE, "+USERNAME);
                System.exit(0);
            }
            else{
                System.out.println("Please enter a valid response.");
                accountManagement();
            }
            }
    public static void checkBalance(){
        System.out.println("Account Balance: $"+balance);
        accountManagement();
    }
    public static void depositChecks(){
        System.out.print("How many checks will you deposit? > ");
            int checkNum = in.nextInt();
            int count = 1;
            while(count<=checkNum){
                System.out.print("Amount of Check #"+count+" > $");
                balance += in.nextDouble();
                count++;
            }
            System.out.println("Your Account Balance is $"+balance);
            accountManagement();
    }
    public static void withdrawMoney(){
        System.out.print("How much will you withdraw? > $");
            double withdraw = in.nextDouble();
            if (withdraw<=balance){
                System.out.println("Old Balance: $"+balance);
                balance = balance-withdraw;
                System.out.println("New Balance: $"+balance);
            }
            else if (withdraw>balance){
                System.out.println("You cannot withdraw more than your $"
                        + balance + " balance.");
                withdrawMoney();
            }
            accountManagement();
    }
}
    

