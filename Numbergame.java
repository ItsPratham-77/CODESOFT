package Output;
import java.util.Scanner;
import java.util.Random;

public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int noofroundwon=0;

        System.out.println("--Welcome To The Number Guessing Game");
        System.out.println("Enter Your Name ");
        String yourname=sc.nextLine();
        System.out.println("--ALL THE BEST--" + yourname);

        boolean playagain=true;
        while (playagain){
            int randomno=1+ra.nextInt(100);
            int noofattempts=3;
            boolean correctguess=false;

            System.out.println("Select The Numbers Between 1 to 100");
            System.out.println("You have 3 attempts ");
            //I Added The Time Calculation Feature . To know much time user requried to gussed the answer right or wrong
            long startTime = System.currentTimeMillis();

            while (noofattempts>0){
                System.out.println("Enter Your Number that you have guessed");
                int guessedno=sc.nextInt();

                if (guessedno==randomno){
                    System.out.println("Correct you gussed it right ");
                    correctguess=true;
                    noofroundwon++;
                    break;
                }else if(guessedno>randomno){
                    System.out.println("The Number is Too High");

                }else {
                    System.out.println("The Number is Too Low");
                }

                noofattempts--;
                System.out.println("You have "+noofattempts+" attempts Left");

            }
            long endTime = System.currentTimeMillis();
            long TotaltimeTakenMillis = endTime - startTime;
            double timeTakenSeconds = TotaltimeTakenMillis / 1000.0;

            System.out.printf(" Time taken this round: %.2f seconds%n" , timeTakenSeconds);

            if (!correctguess){
                System.out.println("WRONG GUESS YOU ARE OUT OF ATTEMPTS");
                System.out.println("The Correct Number was " +randomno);
            }
            System.out.println( yourname +" Do you want to play Another Round ? (yes/no)");
            sc.nextLine();
            String answer=sc.nextLine();

            playagain=answer.equals("yes");
            System.out.println("GAME OVER!! you won " + noofroundwon + "rounds");
            System.out.println("THANK YOU FOR PLAYING THIS GAME " + yourname);

        }

    }
}