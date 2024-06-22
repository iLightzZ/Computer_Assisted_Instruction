//Computer-Assisted Instruction

import java.util.Scanner;
import java.security.SecureRandom;

public class Computer_Assisted_Instruction
{
  private static final SecureRandom randNum = new SecureRandom();
  private static final Scanner input = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    int numOfQs = 0; //number of questions
    System.out.print("Enter your number of questions: ");
    numOfQs = input.nextInt();
    
    while(numOfQs < 1)
    {
      System.out.printf("Number of questions cannot be less than one! Please try again: ");
      numOfQs = input.nextInt();
    }
    
    askQuestion(numOfQs); //method call
    
  }//end main
  
  public static void askQuestion(int numOfQuestions)
  {
    String[] correct = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
    String[] incorrect = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};
    
    while(numOfQuestions != 0)
    {
    
      int ans = 0; //student's answer
      int num1 = 1 + randNum.nextInt(8);
      int num2 = 1 + randNum.nextInt(8);
      int product = num1 * num2;
      
      System.out.printf("%nHow much is %d times %d?%n", num1, num2);
      ans = input.nextInt();
      
      int rand = randNum.nextInt(4); //random number generator for use of comments variation
      
      while(ans != product)
      { 
        System.out.printf(incorrect[rand] + "%n%n%n");
        System.out.printf("How much is %d times %d?%n", num1, num2);
        ans = input.nextInt();
        rand = randNum.nextInt(4);
      }
      System.out.printf(correct[rand] + "%n%n%n");
      --numOfQuestions;
    }//end while
    System.out.printf("Program terminated.%n%n");
  }//end method
  
}//end class