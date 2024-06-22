//Computer-Assisted Instruction (Varying types of problems)

import java.util.Scanner;
import java.security.SecureRandom;

public class Computer_Assisted_Instruction_Vary
{
  private static final SecureRandom randNum = new SecureRandom();
  private static final Scanner input = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    int difficulty = 0;
    System.out.printf("Please choose a difficulty: %n%n1: Single-digit problems%n2: Numbers as large as two digits probelms%n%n");
    System.out.print("Your difficulty: ");
    difficulty = input.nextInt();
    
    while(difficulty < 1 || difficulty > 2) //Error-trapping the user's input
    {
      System.out.printf("%nInvalid difficulty detected. Please try again: ");
      difficulty = input.nextInt();
    }
    
    int operation = 0;
    System.out.printf("%n%n%s%n%n%s%n%s%n%s%n%s%n%s%n%n",
    "Pick a type of arithmetic problem to study:",
    "1: Addition",
    "2: Subtraction",
    "3: Multiplication",
    "4: Division",
    "5: Random mixture of all arithmetics");
    
    System.out.print("Your pick: ");
    operation = input.nextInt();
    
    while(operation < 1 || operation > 5)
    {
      System.out.printf("%nInvalid operation detected. Please try again: ");
      operation = input.nextInt();
    }
    
    askQuestion(difficulty, operation); //method call
    
  }//end main
  
  public static void askQuestion(int diff, int operation)
  {
    int rand = randNum.nextInt(5); //random number generator for use of comments variation & problem variation
    String[] correct = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!", "Outstanding!"};
    String[] incorrect = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying.", "Whoops. Try again."};
    
    String arithmetic = ""; //string to output to the user indicating the arithmetic problem
    int num1 = 0; 
    int num2 = 0;
    
    if(diff == 1)
    {
      num1 = 1 + randNum.nextInt(8);
      num2 = 1 + randNum.nextInt(8);
    }
    else
    {
      num1 = 1 + randNum.nextInt(50);
      num2 = 1 + randNum.nextInt(50);
    }
    
    double user_ans = 0; //student's answer
    double answer = 0; //correct answer of the problem 
    
    int smallest = num1;
    int biggest = num1;
    if(num2 > biggest) //determining the biggest value out of the two numbers to make output neater and to reduce confusion 
    {
      biggest = num2;
    }
    if(num2 < smallest)
    {
      smallest = num2;
    }
    
    switch(operation) //determining the operation
    {
      case 1:
        answer = num1 + num2;
        arithmetic = "plus";
        break;
        
      case 2:
        answer = biggest - smallest;
        arithmetic = "minus";
        break;
      
      case 3:
        answer = num1 * num2;
        arithmetic = "times";
        break;
      
      case 4:
        answer = biggest / smallest;
        arithmetic = "divided by";
        break;
      
      case 5:
        
        switch(randNum.nextInt(4))
      {
        case 0:
          answer = num1 + num2;
          arithmetic = "plus";
          break;
          
        case 1:
          answer = biggest - smallest;
          arithmetic = "minus";
          break;
      
        case 2:
          answer = num1 * num2;
          arithmetic = "times";
          break;
          
        case 3:
          answer = biggest / smallest;
          arithmetic = "divided by";
          break;
        
        default:
          break;
      }//end inner switch
        break;
        
        
      default:
        break;
     }//end switch
      
    System.out.printf("%nHow much is %d %s %d?%n", biggest, arithmetic, smallest);
    user_ans = input.nextDouble();
    
    while(user_ans != answer)
    { 
      System.out.printf(incorrect[rand] + "%n%n%n"); //ouput incorrect message
      System.out.printf("How much is %d %s %d?%n", biggest, arithmetic, smallest);
      user_ans = input.nextDouble();
      rand = randNum.nextInt(5);
    }
    System.out.printf(correct[rand] + "%n%n%n"); //output correct message
    
    int retry = 0;
    System.out.printf("Would you like to contine?(-1 to exit, any integer to continue): ");
    retry = input.nextInt();
    
    if(retry == -1)
    {
      System.out.printf("%nProgram terminated.%n%n");
    }
    else
    {
      askQuestion(diff, operation); //go again
    }
  }//end method
  
}//end class