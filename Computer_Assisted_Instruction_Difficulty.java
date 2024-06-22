//Computer-Assisted Instruction (Difficulty Levels)

import java.util.Scanner;
import java.security.SecureRandom;

public class Computer_Assisted_Instruction_Difficulty
{
  private static final SecureRandom randNum = new SecureRandom();
  private static final Scanner input = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    int level = 0;
    
    System.out.printf("Please choose a difficulty: %n%n1: Single-digit problems%n2: Numbers as large as two digits problems%n%n");
    System.out.print("Your difficulty: ");
    level = input.nextInt();
    
    while(level < 1 || level > 2) //Error-trapping the user's input
    {
      System.out.printf("%nInvalid difficulty detected. Please try again: ");
      level = input.nextInt();
    }
    
    askQuestion(level); //method call
    
  }//end main
  
  public static void askQuestion(int lvl)
  {
    int ans = 0; //student's answer
    int retry = 0;
    int num1 = 0;
    int num2 = 0;
    if(lvl == 1)
    {
      num1 = 1 + randNum.nextInt(8);
      num2 = 1 + randNum.nextInt(8);
    }
    else
    {
      num1 = 9 + randNum.nextInt(80);
      num2 = 9 + randNum.nextInt(80);
    }
    
    int product = num1 * num2;
    int counter = 1;
    
    int rand = randNum.nextInt(4); //random number generator for use of comments variation
    String[] correct = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
    String[] incorrect = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};
    
    System.out.printf("%nHow much is %d times %d?%n", num1, num2);
    ans = input.nextInt();
    
    
    while(ans != product)
    {
        
       System.out.printf(incorrect[rand] + "%n%n%n");
       System.out.printf("How much is %d times %d?%n", num1, num2);
       ans = input.nextInt();
       rand = randNum.nextInt(4);
    }
    System.out.printf(correct[rand] + "%n%n%n");
    System.out.print("Would you like to continue?(enter -1 to exit, any integer to continue): ");
    retry = input.nextInt();
    
    if(retry == -1)
    {
      System.out.printf("%n%nStudent ended the program.%n%n");
    }
    else
    {
      askQuestion(lvl); //method call (again)
    }
  }//end method
  
}//end class