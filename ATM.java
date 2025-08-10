package ATM;

import OperationImplmentation.OperationImpl;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        OperationImpl oi=new OperationImpl();
        Scanner sc=new Scanner(System.in);

        while (true){
            System.out.println("WELCOME TO MY BANK ATM ");
            System.out.println(" 1. TO WITHRAW MONEY ");
            System.out.println(" 2. TO DEPOSITE MONEY ");
            System.out.println(" 3. TO CHECK ACCOUNT BALANCE ");
            System.out.println(" 4. TO CANCEL TRANSATION AND EXIT ");

            int ch=sc.nextInt();

            switch (ch){
                case  1:
                    oi.CashWithraw();
                    break;

                case 2:
                    oi.CashDeposite();
                    break;

                case 3:
                    oi.Balancecheck();
                    break;

                case 4:
                    return;
            }
        }
    }
}
