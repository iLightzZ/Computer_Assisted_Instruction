//Computer-Assisted Instruction (MODIFIED)

import java.util.Scanner;
import java.security.SecureRandom;

public class Computer_Assisted_Instruction_MODIFIED
{
  private static final SecureRandom randNum = new SecureRandom();
  private static final Scanner input = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    
    askQuestion(); //method call
  }//end main
  
  public static void askQuestion()
  {
    
    int score = 0; //student's score
    int questions = 10; //number of questions
    
    while(questions != 0)
    {
      int ans = 0; //student's answer
      int num1 = 1 + randNum.nextInt(8);
      int num2 = 1 + randNum.nextInt(8);
      int product = num1 * num2;
      
      System.out.printf("%nHow much is %d times %d?%n", num1, num2);
      ans = input.nextInt();
      
      if(ans == product)
      {
        ++score;
      }
      System.out.println();
      --questions;
    }//end while
    
    double percentage = 0.0;
    percentage = (double) score/10 * 100;
    if(percentage > 75)
    {
      System.out.printf("Congratulations, you are ready to go to the next level!%n%n");
      
    }
    else
    {
      System.out.printf("Please ask your teacher for extra help.%n%n");
    }
    System.out.printf("---------------------------------------------------------------------%n%n%n%n%n%n");
  }//end method
  
}//end class