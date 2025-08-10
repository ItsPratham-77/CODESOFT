package OperationImplmentation;
import Operation.AccountOperation;

import java.util.Scanner;


public class OperationImpl implements AccountOperation {
        Scanner sc=new Scanner(System.in);
        int totalamount=1000;

    @Override
    public void CashWithraw() {
        //I added this atm pin System for further process
        System.out.println("Enter Your 4 digit ATM PIN");
        String atmpin=sc.next();
        if (atmpin.matches("[1-9]\\d{3}")) {
            System.out.println("Enter an amount to withdraw");
            int withdraw = sc.nextInt();

            if (withdraw <= 0) {
                System.out.println("Enter a VALID AMOUNT TO WITHDRAW");
            } else if (withdraw > totalamount) {
                System.out.println("Insufficient Balance");
            } else {
                totalamount -= withdraw;
                System.out.println("Cash Withdrawal Successful! " + withdraw + " rupees");
            }
        } else {
            System.out.println("Invalid ATM PIN");
        }


    }

    @Override
    public void CashDeposite() {
        System.out.println("Enter A amount to Deposite");
        int deposite=sc.nextInt();
        if (deposite<=0){
            System.out.println("Enter A valid Amount to deposite ");
        }else {
            totalamount +=deposite;
            System.out.println("Amount Deposited Sucessfully " +deposite + " rupess ");
        }
    }

    @Override
    public void Balancecheck() {
        System.out.println("Your Account balance is " + totalamount + " rupess ");


    }
}
